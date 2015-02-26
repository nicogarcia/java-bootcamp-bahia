package com.globant.app.Domain.Discounts.Types;

import com.globant.app.Domain.Discounts.DiscountInfo;
import com.globant.app.Domain.Discounts.DiscountTypes;
import com.globant.app.Domain.Discounts.IDiscount;
import com.globant.app.Domain.Entities.Cart;
import com.globant.app.Domain.PaymentMethods.IPaymentMethod;

/**
 * Defines the discount applied when paying by credit card
 */
public class CreditCardDiscount implements IDiscount {

	@Override public Cart applyDiscount(
			Cart cart, IPaymentMethod paymentType) {

		// Get 10% discount
		DiscountInfo discount = new DiscountInfo("10% OFF for paying with Credit Card!",
				DiscountTypes.tenPercentDiscount());

		// Apply discount to the cart amount
		cart.getAmount().setDiscountInfo(discount);

		return cart;
	}
}
