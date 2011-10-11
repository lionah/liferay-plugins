/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.marketplace.util;

import com.liferay.portal.kernel.util.Digester;
import com.liferay.portal.kernel.util.DigesterUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;
import com.liferay.util.Encryptor;

import java.security.Key;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Hex;

/**
 * @author Peter Shin
 */
public class MarketplaceUtil {

	public static String generateToken() {
		long timestamp = System.currentTimeMillis();

		String token = DigesterUtil.digestHex(
			Digester.MD5, String.valueOf(timestamp), PortalUUIDUtil.generate());

		_tokenDelayQueue.put(new TokenDelayed(token));

		return token;
	}

	public static String getClientId(long userId) throws Exception {
		String name = String.valueOf(userId);
		String encryptedUserId = UserLocalServiceUtil.encryptUserId(name);

		return new String(Hex.encodeHex(encryptedUserId.getBytes()));
	}

	public static String getClientURL(HttpServletRequest request) {
		String portalURL = PortalUtil.getPortalURL(request);
		String contextPath = request.getContextPath();

		return portalURL.concat(contextPath).concat("/marketplace_client/");
	}

	public static String getCredentials(User user) throws Exception {
		return ExpandoValueLocalServiceUtil.getData(
			user.getCompanyId(), User.class.getName(), "MP", "credentials",
			user.getUserId(), StringPool.BLANK);
	}

	public static User getUser(Key key, String clientId) throws Exception {
		byte[] bytes = Hex.decodeHex(clientId.toCharArray());
		String encryptedUserId = new String(bytes);

		String userIdString = Encryptor.decrypt(key, encryptedUserId);

		return UserLocalServiceUtil.getUser(GetterUtil.getLong(userIdString));
	}

	public static boolean isValidToken(String token) {
		TokenDelayed tokenDelayed = new TokenDelayed(token);

		if (!_tokenDelayQueue.remove(tokenDelayed)) {
			return false;
		}

		removeExpiredTokens();

		return true;
	}

	public static void removeExpiredTokens() {
		while (_tokenDelayQueue.poll() != null);
	}

	private static final long _TOKEN_EXPIRATION = 5 * Time.MINUTE;

	private static DelayQueue<TokenDelayed> _tokenDelayQueue =
		new DelayQueue<TokenDelayed>();

	private static class TokenDelayed implements Delayed {

		public TokenDelayed(String token) {
			if (token == null) {
				throw new NullPointerException("Token is null");
			}

			_createTime = System.currentTimeMillis();
			_token = token;
		}

		public int compareTo(Delayed delayed) {
			TokenDelayed tokenDelayed = (TokenDelayed)delayed;

			long result = _createTime - tokenDelayed._createTime;

			if (result == 0) {
				return 0;
			}
			else if (result > 0) {
				return 1;
			}
			else {
				return -1;
			}
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}

			if (!(obj instanceof TokenDelayed)) {
				return false;
			}

			TokenDelayed tokenDelayed = (TokenDelayed)obj;

			if (_token.equals(tokenDelayed._token)) {
				return true;
			}

			return false;
		}

		public long getDelay(TimeUnit timeUnit) {
			long sourceDuration =
				_TOKEN_EXPIRATION + _createTime - System.currentTimeMillis();

			return timeUnit.convert(sourceDuration, TimeUnit.MILLISECONDS);
		}

		@Override
		public int hashCode() {
			return _token.hashCode();
		}

		private final long _createTime;
		private final String _token;

	}

}