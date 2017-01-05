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

package com.liferay.sample.birthday.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.liferay.sample.birthday.model.Birthday;
import com.liferay.sample.birthday.model.BirthdayModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Birthday service. Represents a row in the &quot;Sample_Birthday_Birthday&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.sample.birthday.model.BirthdayModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link BirthdayImpl}.
 * </p>
 *
 * @author Ryan Park
 * @see BirthdayImpl
 * @see com.liferay.sample.birthday.model.Birthday
 * @see com.liferay.sample.birthday.model.BirthdayModel
 * @generated
 */
@ProviderType
public class BirthdayModelImpl extends BaseModelImpl<Birthday>
	implements BirthdayModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a birthday model instance should use the {@link com.liferay.sample.birthday.model.Birthday} interface instead.
	 */
	public static final String TABLE_NAME = "Sample_Birthday_Birthday";
	public static final Object[][] TABLE_COLUMNS = {
			{ "birthdayId", Types.BIGINT },
			{ "name", Types.VARCHAR },
			{ "date_", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table Sample_Birthday_Birthday (birthdayId LONG not null primary key,name VARCHAR(75) null,date_ DATE null)";
	public static final String TABLE_SQL_DROP = "drop table Sample_Birthday_Birthday";
	public static final String ORDER_BY_JPQL = " ORDER BY birthday.birthdayId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Sample_Birthday_Birthday.birthdayId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.sample.birthday.model.Birthday"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.sample.birthday.model.Birthday"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.sample.birthday.model.Birthday"));

	public BirthdayModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _birthdayId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBirthdayId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _birthdayId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Birthday.class;
	}

	@Override
	public String getModelClassName() {
		return Birthday.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("birthdayId", getBirthdayId());
		attributes.put("name", getName());
		attributes.put("date", getDate());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long birthdayId = (Long)attributes.get("birthdayId");

		if (birthdayId != null) {
			setBirthdayId(birthdayId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Date date = (Date)attributes.get("date");

		if (date != null) {
			setDate(date);
		}
	}

	@Override
	public long getBirthdayId() {
		return _birthdayId;
	}

	@Override
	public void setBirthdayId(long birthdayId) {
		_birthdayId = birthdayId;
	}

	@Override
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_name = name;
	}

	@Override
	public Date getDate() {
		return _date;
	}

	@Override
	public void setDate(Date date) {
		_date = date;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Birthday.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Birthday toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Birthday)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		BirthdayImpl birthdayImpl = new BirthdayImpl();

		birthdayImpl.setBirthdayId(getBirthdayId());
		birthdayImpl.setName(getName());
		birthdayImpl.setDate(getDate());

		birthdayImpl.resetOriginalValues();

		return birthdayImpl;
	}

	@Override
	public int compareTo(Birthday birthday) {
		long primaryKey = birthday.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Birthday)) {
			return false;
		}

		Birthday birthday = (Birthday)obj;

		long primaryKey = birthday.getPrimaryKey();

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
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<Birthday> toCacheModel() {
		BirthdayCacheModel birthdayCacheModel = new BirthdayCacheModel();

		birthdayCacheModel.birthdayId = getBirthdayId();

		birthdayCacheModel.name = getName();

		String name = birthdayCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			birthdayCacheModel.name = null;
		}

		Date date = getDate();

		if (date != null) {
			birthdayCacheModel.date = date.getTime();
		}
		else {
			birthdayCacheModel.date = Long.MIN_VALUE;
		}

		return birthdayCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{birthdayId=");
		sb.append(getBirthdayId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", date=");
		sb.append(getDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.liferay.sample.birthday.model.Birthday");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>birthdayId</column-name><column-value><![CDATA[");
		sb.append(getBirthdayId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>date</column-name><column-value><![CDATA[");
		sb.append(getDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = Birthday.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Birthday.class
		};
	private long _birthdayId;
	private String _name;
	private Date _date;
	private Birthday _escapedModel;
}