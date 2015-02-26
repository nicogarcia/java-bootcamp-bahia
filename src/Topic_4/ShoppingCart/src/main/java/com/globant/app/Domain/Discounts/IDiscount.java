package com.globant.app.Domain.Discounts;

import com.globant.app.Domain.Entities.Cart;
import com.globant.app.Domain.PaymentMethods.IPaymentMethod;

public interface IDiscount {

	public Cart applyDiscount(Cart cart,
			IPaymentMethod paymentType);
}
