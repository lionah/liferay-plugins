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

package com.liferay.marketplace.servlet;

import com.liferay.marketplace.util.MarketplaceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Peter Shin
 */
public class MarketplaceClientServlet extends HttpServlet {

	@Override
	public void service(
		HttpServletRequest request, HttpServletResponse response) {

		try {
			String path = HttpUtil.fixPath(request.getPathInfo());
			String[] pathArray = StringUtil.split(path, CharPool.SLASH);

			String cmd = GetterUtil.getString(pathArray[0]);

			if (cmd.equals("get_credentials")) {
				getCredentials(request, response);
			}
			else if (cmd.equals("get_token")) {
				getToken(request, response);
			}
			else if (cmd.equals("update_credentials")) {
				updateCredentials(request, response);
			}
		}
		catch (Exception e) {
			_log.error(e, e);
		}
	}

	protected static void getCredentials(
			HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		String path = HttpUtil.fixPath(request.getPathInfo());
		String[] pathArray = StringUtil.split(path, CharPool.SLASH);

		String token = GetterUtil.getString(pathArray[1]);
		String clientId = GetterUtil.getString(pathArray[2]);

		if (!MarketplaceUtil.isValidToken(token)) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

			return;
		}

		Company company = PortalUtil.getCompany(request);
		User user = MarketplaceUtil.getUser(company.getKeyObj(), clientId);

		String content = MarketplaceUtil.getCredentials(user);

		response.setContentType(ContentTypes.TEXT_PLAIN_UTF8);

		ServletResponseUtil.write(response, content.getBytes(StringPool.UTF8));
	}

	protected static void getToken(
			HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		String content = MarketplaceUtil.generateToken();

		response.setContentType(ContentTypes.TEXT_PLAIN_UTF8);

		ServletResponseUtil.write(response, content.getBytes(StringPool.UTF8));
	}

	protected static void updateCredentials(
			HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		String path = HttpUtil.fixPath(request.getPathInfo());
		String[] pathArray = StringUtil.split(path, CharPool.SLASH);

		String token = GetterUtil.getString(pathArray[1]);
		String clientId = GetterUtil.getString(pathArray[2]);
		String credentials = GetterUtil.getString(pathArray[3]);

		if (!MarketplaceUtil.isValidToken(token)) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

			return;
		}

		Company company = PortalUtil.getCompany(request);
		User user = MarketplaceUtil.getUser(company.getKeyObj(), clientId);

		ExpandoValueLocalServiceUtil.addValue(
			user.getCompanyId(), User.class.getName(), "MP", "credentials",
			user.getUserId(), credentials);

		response.setStatus(HttpServletResponse.SC_OK);
	}

	private static Log _log = LogFactoryUtil.getLog(
		MarketplaceClientServlet.class);

}