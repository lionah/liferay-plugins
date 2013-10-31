/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.testpaypal.portlet;

import com.liferay.compat.portal.util.PortalUtil;
import com.liferay.compat.util.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.SessionParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.testpaypal.util.PayPalUtil;

import com.paypal.api.payments.Item;
import com.paypal.api.payments.Payment;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.PortletURL;

/**
 * @author Douglas Wong
 */
public class TestPayPalPortlet extends MVCPortlet {

	public void confirmAccountPayment(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException, SystemException {

		String payPalPaymentId = SessionParamUtil.getString(
			actionRequest, "payPalPaymentId");

		String payPalPayerId = ParamUtil.getString(
			actionRequest, "payPalPayerId");

		try {
			PayPalUtil.executeAccountPayment(payPalPaymentId, payPalPayerId);
		}
		catch (Exception e) {
		}
	}

	public void purchaseWithAccountPayment(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException, SystemException {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		String portletId = PortalUtil.getPortletId(actionRequest);

		PortletURL portletURL = PortletURLFactoryUtil.create(
			actionRequest, portletId, themeDisplay.getPlid(),
			PortletRequest.RENDER_PHASE);

		portletURL.setParameter(
			"mvcPath", "/purchase/confirm_account_payment.jsp");

		String returnURL = portletURL.toString();

		portletURL.setParameter(
			"mvcPath", "/purchase/cancel_account_payment.jsp");

		String cancelURL = portletURL.toString();

		List<Item> items = new ArrayList<Item>();

		Item item1 = getItem("Boba Milk Tea", "4", "3.00", "USD");
		Item item2 = getItem("Caramel Macchiato", "1", "4.25", "USD");
		Item item3 = getItem("Pumpkin Spice Latte", "2", "4.50", "USD");

		items.add(item1);
		items.add(item2);
		items.add(item3);

		try {
			Payment payment = PayPalUtil.getAccountPayment(
				items, "25.25", "USD", returnURL, cancelURL);

			PortletSession portletSession = actionRequest.getPortletSession();

			portletSession.setAttribute("payPalPaymentId", payment.getId());

			String redirectURL = PayPalUtil.getApprovalURL(payment);

			actionResponse.sendRedirect(redirectURL);
		}
		catch (Exception e) {
		}
	}

	public void purchaseWithRest(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException, SystemException {

		List<Item> items = new ArrayList<Item>();

		Item item1 = getItem("Boba Milk Tea", "3", "3.00", "USD");
		Item item2 = getItem("Caramel Macchiato", "5", "4.25", "USD");
		Item item3 = getItem("Pumpkin Spice Latte", "1", "4.50", "USD");

		items.add(item1);
		items.add(item2);
		items.add(item3);

		String total = "34.75";
		String currencyCode = "USD";

		String ccNumber = "4417119669820331";
		String ccType = "visa";
		int ccExpireMonth = 11;
		int ccExpireYear = 2018;
		String ccCvv2 = "874";
		String ccFirstName = "Joe";
		String ccLastName = "Shopper";

		String street = "1400 Montefino Ave";
		String city = "Diamond Bar";
		String countryCode = "US";
		String postalCode = "91765";
		String state = "CA";

		try {
			PayPalUtil.executeRestPayment(
				items, total, currencyCode, ccNumber, ccType, ccExpireMonth,
				ccExpireYear, ccCvv2, ccFirstName, ccLastName, street, city,
				countryCode, postalCode, state);
		}
		catch (Exception e) {
		}
	}

	protected Item getItem(
		String name, String quantity, String price, String currencyCode) {

		Item item = new Item();

		item.setCurrency(currencyCode);
		item.setName(name);
		item.setPrice(price);
		item.setQuantity(quantity);

		return item;
	}

}