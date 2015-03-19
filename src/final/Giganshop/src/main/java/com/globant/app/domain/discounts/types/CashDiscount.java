package com.globant.app.domain.discounts.types;

import com.globant.app.domain.discounts.DiscountInfo;
import com.globant.app.domain.discounts.IDiscount;
import com.globant.app.domain.discounts.PredefinedDiscounts;
import com.globant.app.domain.entities.carts.OrderCart;
import com.globant.app.domain.entities.items.CartItem;
import com.globant.app.domain.paymentMethods.IPaymentMethod;

import java.util.Collections;

/**
 * Defines the discount applied when paying by cash
 */
public class CashDiscount implements IDiscount {

	@Override public OrderCart applyDiscount(
			OrderCart cart, IPaymentMethod paymentType) {

		if (cart.getCartProducts().size() > 1) {

			// Get the most expensive item
			CartItem mostExpensiveItem = Collections.max(cart.getCartProducts());

			// Get 90% discount
			DiscountInfo discount = PredefinedDiscounts
					.ninetyPercentDiscount();

			// Apply discount
			mostExpensiveItem.setDiscountInfo(discount);
		}

		return cart;
	}
}