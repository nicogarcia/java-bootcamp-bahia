package com.globant.app.services;

import com.globant.app.domain.discounts.IDiscount;
import com.globant.app.domain.paymentMethods.IPaymentMethod;
import org.springframework.stereotype.Service;

@Service
public interface IDiscountService {

	public IDiscount getDiscount(
			IPaymentMethod paymentMethod);
}
