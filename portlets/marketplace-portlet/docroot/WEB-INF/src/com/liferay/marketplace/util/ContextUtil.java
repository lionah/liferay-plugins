/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

import com.liferay.compat.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.StringPool;

/**
 * @author Joan Kim
 */
public class ContextUtil {

	public static String getContextName(String contextPath) {
		String contextName = contextPath;

		if (contextName.length() == 0) {
			return StringPool.BLANK;
		}

		if (contextName.startsWith(StringPool.FORWARD_SLASH)) {
			contextName = contextName.substring(1);
		}

		if (contextName.endsWith(StringPool.FORWARD_SLASH)) {
			contextName = contextName.substring(0, contextName.length() - 1);
		}

		while (hasMarketplacePluginType(contextName)) {
			int pos = contextName.lastIndexOf(StringPool.DASH);

			String pluginType = contextName.substring(
				pos, contextName.length());

			if (ArrayUtil.contains(_MARKETPLACE_PLUGIN_TYPES, pluginType)) {
				return contextName;
			}

			if (pos > 0) {
				contextName = contextName.substring(0, pos);
			}
		}

		return contextName;
	}

	protected static boolean hasMarketplacePluginType(String contextName) {
		for (String pluginType : _MARKETPLACE_PLUGIN_TYPES) {
			if (contextName.contains(pluginType)) {
				return true;
			}
		}

		return false;
	}

	private static final String[] _MARKETPLACE_PLUGIN_TYPES = {
		"-ext", "-hook", "-layouttpl", "-portlet", "-theme", "-web"
	};

}