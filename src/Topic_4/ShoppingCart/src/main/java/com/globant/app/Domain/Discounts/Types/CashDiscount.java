package com.globant.app.Domain.Discounts.Types;

import com.globant.app.Domain.Discounts.DiscountInfo;
import com.globant.app.Domain.Discounts.DiscountTypes;
import com.globant.app.Domain.Discounts.IDiscount;
import com.globant.app.Domain.Entities.Cart;
import com.globant.app.Domain.Entities.CartItem;
import com.globant.app.Domain.PaymentMethods.IPaymentMethod;

import java.util.Collections;

/**
 * Defines the discount applied when paying by cash
 */
public class CashDiscount implements IDiscount {

	@Override public Cart applyDiscount(
			Cart cart, IPaymentMethod paymentType) {

		if (cart.getItems().size() > 1) {

			// Get the most expensive item
			CartItem mostExpensiveItem = Collections.max(cart.getItems());

			// Get 90% discount
			DiscountInfo discount = DiscountTypes
					.ninetyPercentDiscount();

			// Apply discount
			mostExpensiveItem.setDiscountInfo(discount);
		}

		return cart;
	}
}