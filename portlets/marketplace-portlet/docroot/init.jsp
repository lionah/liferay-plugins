<%--
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
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.marketplace.util.MarketplaceConstants" %><%@
page import="com.liferay.marketplace.util.MarketplaceUtil" %><%@
page import="com.liferay.marketplace.util.PortletKeys" %><%@
page import="com.liferay.portal.kernel.util.HttpUtil" %><%@
page import="com.liferay.portal.kernel.util.StringPool" %><%@
page import="com.liferay.portal.kernel.util.Validator" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<%
String iFrameURL = StringPool.BLANK;

if (Validator.equals(portletDisplay.getId(), PortletKeys.MY_MARKETPLACE)) {
	String refererURL = MarketplaceConstants.MARKETPLACE_URL_MANAGE_APPS;

	refererURL = HttpUtil.setParameter(refererURL, "clientURL", MarketplaceUtil.getClientURL(request));
	refererURL = HttpUtil.setParameter(refererURL, "clientId", MarketplaceUtil.getClientId(user.getUserId()));

	iFrameURL = HttpUtil.setParameter(MarketplaceConstants.MARKETPLACE_URL_LOGOUT, "referer", refererURL);
}
else {
	String refererURL = MarketplaceConstants.MARKETPLACE_URL_HOME;

	refererURL = HttpUtil.setParameter(refererURL, "clientURL", MarketplaceUtil.getClientURL(request));
	refererURL = HttpUtil.setParameter(refererURL, "clientId", MarketplaceUtil.getClientId(user.getUserId()));

	iFrameURL = HttpUtil.setParameter(MarketplaceConstants.MARKETPLACE_URL_LOGOUT, "referer", refererURL);
}
%>