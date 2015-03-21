package com.globant.app.services.implementations;

import com.globant.app.domain.discounts.IDiscount;
import com.globant.app.domain.discounts.types.CashDiscount;
import com.globant.app.domain.discounts.types.CreditCardDiscount;
import com.globant.app.domain.discounts.types.PaypalDiscount;
import com.globant.app.domain.paymentMethods.CashPayment;
import com.globant.app.domain.paymentMethods.CreditCardPayment;
import com.globant.app.domain.paymentMethods.IPaymentMethod;
import com.globant.app.domain.paymentMethods.PaypalPayment;
import com.globant.app.services.IDiscountService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages the bindings between the payment method and discount applied.
 */
@Service
public class DiscountService implements IDiscountService {

	private Map<Class<? extends IPaymentMethod>, Class<? extends IDiscount>> discountByPaymentMap =
			new HashMap<Class<? extends IPaymentMethod>, Class<? extends IDiscount>>(5);

	public DiscountService(){
		loadBindings();
	}

	public void loadBindings() {
		bind(CashPayment.class, CashDiscount.class);
		bind(CreditCardPayment.class, CreditCardDiscount.class);
		bind(PaypalPayment.class, PaypalDiscount.class);
	}

	private void bind(Class<? extends IPaymentMethod> paymentType, Class<? extends IDiscount> discount) {
		discountByPaymentMap.put(paymentType, discount);
	}

	/**
	 * Returns the discount type according to the payment type
	 */
	public IDiscount getDiscount(
			IPaymentMethod paymentType) {
		IDiscount discount = null;
		try {
			discount = discountByPaymentMap.get(paymentType.getClass()).newInstance();

		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return discount;
	}

}
