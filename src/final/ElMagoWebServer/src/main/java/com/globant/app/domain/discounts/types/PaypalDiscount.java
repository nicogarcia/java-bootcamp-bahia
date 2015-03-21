package com.globant.app.domain.discounts.types;

import com.globant.app.domain.discounts.DiscountInfo;
import com.globant.app.domain.discounts.IDiscount;
import com.globant.app.domain.discounts.PredefinedDiscounts;
import com.globant.app.domain.entities.carts.OrderCart;
import com.globant.app.domain.entities.items.CartItem;
import com.globant.app.domain.paymentMethods.IPaymentMethod;

import java.util.Collections;

/**
 * Defines the discount applied when paying by Paypal
 */
public class PaypalDiscount implements IDiscount {
	@Override public OrderCart applyDiscount(
			OrderCart cart, IPaymentMethod paymentType) {

		if (cart.getCartProducts().size() > 1) {

			// Select the cheapest item
			CartItem cheapestItem = Collections.min(cart.getCartProducts());

			// Select the discount to be applied
			DiscountInfo discount = PredefinedDiscounts.freeDiscount();

			// Apply discount
			cheapestItem.setDiscountInfo(discount);
		}

		return cart;
	}
}
