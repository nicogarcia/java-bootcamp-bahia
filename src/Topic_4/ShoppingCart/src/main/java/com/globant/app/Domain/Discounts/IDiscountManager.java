package com.globant.app.Domain.Discounts;

import com.globant.app.Domain.PaymentMethods.IPaymentMethod;

public interface IDiscountManager {

	public IDiscount getDiscount(
			IPaymentMethod paymentMethod);
}
