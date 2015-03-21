package com.globant.app.domain.discounts.types;

import com.globant.app.domain.discounts.DiscountInfo;
import com.globant.app.domain.discounts.IDiscount;
import com.globant.app.domain.discounts.PredefinedDiscounts;
import com.globant.app.domain.entities.carts.OrderCart;
import com.globant.app.domain.paymentMethods.IPaymentMethod;

/**
 * Defines the discount applied when paying by credit card
 */
public class CreditCardDiscount implements IDiscount {

	@Override public OrderCart applyDiscount(
			OrderCart cart, IPaymentMethod paymentType) {

		// Get 10% discount
		DiscountInfo discount = new DiscountInfo("¡10% OFF!",
				PredefinedDiscounts.tenPercentDiscount());

		// Apply discount to the cart amount
		cart.getAmount().setDiscountInfo(discount);

		return cart;
	}
}
