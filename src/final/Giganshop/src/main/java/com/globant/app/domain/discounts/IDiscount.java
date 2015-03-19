package com.globant.app.domain.discounts;

import com.globant.app.domain.entities.carts.OrderCart;
import com.globant.app.domain.paymentMethods.IPaymentMethod;

public interface IDiscount {

	public OrderCart applyDiscount(OrderCart cart,
			IPaymentMethod paymentType);
}
