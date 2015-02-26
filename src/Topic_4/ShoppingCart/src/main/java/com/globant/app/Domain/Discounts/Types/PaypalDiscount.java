package com.globant.app.Domain.Discounts.Types;

import com.globant.app.Domain.Discounts.DiscountInfo;
import com.globant.app.Domain.Discounts.IDiscount;
import com.globant.app.Domain.Entities.Cart;
import com.globant.app.Domain.Entities.CartItem;
import com.globant.app.Domain.PaymentMethods.IPaymentMethod;
import com.globant.app.Domain.Discounts.DiscountTypes;

import java.util.Collections;

/**
 * Defines the discount applied when paying by Paypal
 */
public class PaypalDiscount implements IDiscount {
	@Override public Cart applyDiscount(
			Cart cart, IPaymentMethod paymentType) {

		if (cart.getItems().size() > 1) {

			// Select the cheapest item
			CartItem cheapestItem = Collections.min(cart.getItems());

			// Select the discount to be applied
			DiscountInfo discount = DiscountTypes.freeDiscount();

			// Apply discount
			cheapestItem.setDiscountInfo(discount);
		}

		return cart;
	}
}
