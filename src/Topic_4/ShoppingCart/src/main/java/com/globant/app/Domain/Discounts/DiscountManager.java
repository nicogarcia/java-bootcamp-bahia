package com.globant.app.Domain.Discounts;

import com.globant.app.Domain.Discounts.Types.CashDiscount;
import com.globant.app.Domain.Discounts.Types.CreditCardDiscount;
import com.globant.app.Domain.Discounts.Types.PaypalDiscount;
import com.globant.app.Domain.PaymentMethods.CashPayment;
import com.globant.app.Domain.PaymentMethods.CreditCardPayment;
import com.globant.app.Domain.PaymentMethods.IPaymentMethod;
import com.globant.app.Domain.PaymentMethods.PaypalPayment;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages the bindings between the payment method and discount applied.
 */
public class DiscountManager implements IDiscountManager {

	private Map<Class<? extends IPaymentMethod>, Class<? extends IDiscount>> discountByPaymentMap =
			new HashMap<Class<? extends IPaymentMethod>, Class<? extends IDiscount>>(5);

	public DiscountManager(){
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
