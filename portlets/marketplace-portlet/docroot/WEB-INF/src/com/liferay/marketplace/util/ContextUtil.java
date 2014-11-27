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

import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.StringPool;

/**
 * @author Joan Kim
 */
public class ContextUtil {

	public static String getContextName(String context) {
		String contextName = FileUtil.getShortFileName(context);

		if (contextName.length() == 0) {
			return StringPool.BLANK;
		}

		while (contextName.contains(StringPool.DASH)) {
			if (contextName.endsWith("-ext") || contextName.endsWith("-hook") ||
				contextName.endsWith("-layouttpl") ||
				contextName.endsWith("-portlet") ||
				contextName.endsWith("-theme") ||
				contextName.endsWith("-web")) {

				return contextName;
			}

			int pos = contextName.lastIndexOf(StringPool.DASH);

			if (pos > 0) {
				contextName = contextName.substring(0, pos);
			}
			else {
				break;
			}
		}

		return contextName;
	}

}