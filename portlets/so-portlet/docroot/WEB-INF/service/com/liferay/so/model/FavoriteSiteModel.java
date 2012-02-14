/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package com.liferay.so.model;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import com.liferay.so.service.persistence.FavoriteSitePK;

import java.io.Serializable;

/**
 * The base model interface for the FavoriteSite service. Represents a row in the &quot;SO_FavoriteSite&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.so.model.impl.FavoriteSiteModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.so.model.impl.FavoriteSiteImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FavoriteSite
 * @see com.liferay.so.model.impl.FavoriteSiteImpl
 * @see com.liferay.so.model.impl.FavoriteSiteModelImpl
 * @generated
 */
public interface FavoriteSiteModel extends BaseModel<FavoriteSite> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a favorite site model instance should use the {@link FavoriteSite} interface instead.
	 */

	/**
	 * Returns the primary key of this favorite site.
	 *
	 * @return the primary key of this favorite site
	 */
	public FavoriteSitePK getPrimaryKey();

	/**
	 * Sets the primary key of this favorite site.
	 *
	 * @param primaryKey the primary key of this favorite site
	 */
	public void setPrimaryKey(FavoriteSitePK primaryKey);

	/**
	 * Returns the user ID of this favorite site.
	 *
	 * @return the user ID of this favorite site
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this favorite site.
	 *
	 * @param userId the user ID of this favorite site
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this favorite site.
	 *
	 * @return the user uuid of this favorite site
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this favorite site.
	 *
	 * @param userUuid the user uuid of this favorite site
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the group ID of this favorite site.
	 *
	 * @return the group ID of this favorite site
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this favorite site.
	 *
	 * @param groupId the group ID of this favorite site
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this favorite site.
	 *
	 * @return the company ID of this favorite site
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this favorite site.
	 *
	 * @param companyId the company ID of this favorite site
	 */
	public void setCompanyId(long companyId);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(FavoriteSite favoriteSite);

	public int hashCode();

	public CacheModel<FavoriteSite> toCacheModel();

	public FavoriteSite toEscapedModel();

	public String toString();

	public String toXmlString();
}