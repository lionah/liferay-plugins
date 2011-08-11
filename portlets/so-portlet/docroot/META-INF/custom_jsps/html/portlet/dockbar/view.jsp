<%
/**
 * Copyright (c) 2008-2010 Liferay, Inc. All rights reserved.
 *
 * This file is part of Liferay Social Office. Liferay Social Office is free
 * software: you can redistribute it and/or modify it under the terms of the GNU
 * Affero General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 *
 * Liferay Social Office is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Affero General Public License
 * for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * Liferay Social Office. If not, see http://www.gnu.org/licenses/agpl-3.0.html.
 */
%>

<%@ include file="/html/portlet/dockbar/init.jsp" %>

<liferay-util:buffer var="html">
	<liferay-util:include page="/html/portlet/dockbar/view.portal.jsp" />
</liferay-util:buffer>

<%
int x = html.indexOf("<li class=\"my-sites has-submenu\" id=\"_145_mySites\">");
%>

<c:choose>
	<c:when test="<%= x > 0 %>">
		<%= html.substring(0, x) %>

		<%
		Group userGroup = user.getGroup();

		Layout userHomeLayout = LayoutLocalServiceUtil.getLayout(userGroup.getGroupId(), true, 1);

		userHomeLayout.getRegularURL(request);
		%>

		<li>
			<liferay-ui:icon message="<%= userGroup.getDescriptiveName() %>" src='<%= themeDisplay.getPathContext() + "/html/icons/social_office.png" %>' />

			<a href="<%= PortalUtil.getLayoutFullURL(userHomeLayout, themeDisplay) %>"><%= userHomeLayout.getName() %></a>
		</li>

		<li class="aui-toolbar-separator">
			<span></span>
		</li>

		<%= html.substring(x) %>
	</c:when>
	<c:otherwise>
		<%= html %>
	</c:otherwise>
</c:choose>

