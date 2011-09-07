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

package com.liferay.socialcoding.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.liferay.socialcoding.model.JIRAChangeGroup;
import com.liferay.socialcoding.model.JIRAChangeGroupModel;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.Date;

/**
 * The base model implementation for the JIRAChangeGroup service. Represents a row in the &quot;changegroup&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.socialcoding.model.JIRAChangeGroupModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link JIRAChangeGroupImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JIRAChangeGroupImpl
 * @see com.liferay.socialcoding.model.JIRAChangeGroup
 * @see com.liferay.socialcoding.model.JIRAChangeGroupModel
 * @generated
 */
public class JIRAChangeGroupModelImpl extends BaseModelImpl<JIRAChangeGroup>
	implements JIRAChangeGroupModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a j i r a change group model instance should use the {@link com.liferay.socialcoding.model.JIRAChangeGroup} interface instead.
	 */
	public static final String TABLE_NAME = "changegroup";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", Types.BIGINT },
			{ "author", Types.VARCHAR },
			{ "created", Types.TIMESTAMP },
			{ "issueid", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table changegroup (id LONG not null primary key,author VARCHAR(75) null,created DATE null,issueid LONG)";
	public static final String TABLE_SQL_DROP = "drop table changegroup";
	public static final String ORDER_BY_JPQL = " ORDER BY jiraChangeGroup.createDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY changegroup.created DESC";
	public static final String DATA_SOURCE = "jiraDataSource";
	public static final String SESSION_FACTORY = "jiraSessionFactory";
	public static final String TX_MANAGER = "jiraTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.socialcoding.model.JIRAChangeGroup"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.socialcoding.model.JIRAChangeGroup"),
			true);

	public Class<?> getModelClass() {
		return JIRAChangeGroup.class;
	}

	public String getModelClassName() {
		return JIRAChangeGroup.class.getName();
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.socialcoding.model.JIRAChangeGroup"));

	public JIRAChangeGroupModelImpl() {
	}

	public long getPrimaryKey() {
		return _jiraChangeGroupId;
	}

	public void setPrimaryKey(long primaryKey) {
		setJiraChangeGroupId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_jiraChangeGroupId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getJiraChangeGroupId() {
		return _jiraChangeGroupId;
	}

	public void setJiraChangeGroupId(long jiraChangeGroupId) {
		_jiraChangeGroupId = jiraChangeGroupId;
	}

	public String getJiraUserId() {
		if (_jiraUserId == null) {
			return StringPool.BLANK;
		}
		else {
			return _jiraUserId;
		}
	}

	public void setJiraUserId(String jiraUserId) {
		_jiraUserId = jiraUserId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public long getJiraIssueId() {
		return _jiraIssueId;
	}

	public void setJiraIssueId(long jiraIssueId) {
		_jiraIssueId = jiraIssueId;
	}

	@Override
	public JIRAChangeGroup toEscapedModel() {
		if (isEscapedModel()) {
			return (JIRAChangeGroup)this;
		}
		else {
			if (_escapedModelProxy == null) {
				_escapedModelProxy = (JIRAChangeGroup)Proxy.newProxyInstance(_classLoader,
						_escapedModelProxyInterfaces,
						new AutoEscapeBeanHandler(this));
			}

			return _escapedModelProxy;
		}
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(0,
					JIRAChangeGroup.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		JIRAChangeGroupImpl jiraChangeGroupImpl = new JIRAChangeGroupImpl();

		jiraChangeGroupImpl.setJiraChangeGroupId(getJiraChangeGroupId());
		jiraChangeGroupImpl.setJiraUserId(getJiraUserId());
		jiraChangeGroupImpl.setCreateDate(getCreateDate());
		jiraChangeGroupImpl.setJiraIssueId(getJiraIssueId());

		jiraChangeGroupImpl.resetOriginalValues();

		return jiraChangeGroupImpl;
	}

	public int compareTo(JIRAChangeGroup jiraChangeGroup) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(),
				jiraChangeGroup.getCreateDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		JIRAChangeGroup jiraChangeGroup = null;

		try {
			jiraChangeGroup = (JIRAChangeGroup)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = jiraChangeGroup.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<JIRAChangeGroup> toCacheModel() {
		JIRAChangeGroupCacheModel jiraChangeGroupCacheModel = new JIRAChangeGroupCacheModel();

		jiraChangeGroupCacheModel.jiraChangeGroupId = getJiraChangeGroupId();

		jiraChangeGroupCacheModel.jiraUserId = getJiraUserId();

		String jiraUserId = jiraChangeGroupCacheModel.jiraUserId;

		if ((jiraUserId != null) && (jiraUserId.length() == 0)) {
			jiraChangeGroupCacheModel.jiraUserId = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			jiraChangeGroupCacheModel.createDate = createDate.getTime();
		}
		else {
			jiraChangeGroupCacheModel.createDate = Long.MIN_VALUE;
		}

		jiraChangeGroupCacheModel.jiraIssueId = getJiraIssueId();

		return jiraChangeGroupCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{jiraChangeGroupId=");
		sb.append(getJiraChangeGroupId());
		sb.append(", jiraUserId=");
		sb.append(getJiraUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", jiraIssueId=");
		sb.append(getJiraIssueId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.liferay.socialcoding.model.JIRAChangeGroup");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>jiraChangeGroupId</column-name><column-value><![CDATA[");
		sb.append(getJiraChangeGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jiraUserId</column-name><column-value><![CDATA[");
		sb.append(getJiraUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jiraIssueId</column-name><column-value><![CDATA[");
		sb.append(getJiraIssueId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = JIRAChangeGroup.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			JIRAChangeGroup.class
		};
	private long _jiraChangeGroupId;
	private String _jiraUserId;
	private Date _createDate;
	private long _jiraIssueId;
	private transient ExpandoBridge _expandoBridge;
	private JIRAChangeGroup _escapedModelProxy;
}