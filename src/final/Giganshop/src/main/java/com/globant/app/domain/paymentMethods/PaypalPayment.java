package com.globant.app.domain.paymentMethods;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.globant.app.domain.utilities.PaymentMethodInjector;
import org.springframework.stereotype.Component;

@Component
public class PaypalPayment extends PaymentMethod {

	public static final String CLASS_NAME = "paypal";

	@JsonProperty
	private final String NAME = "Paypal";

	public PaypalPayment() {
		paymentInfo = PaymentMethodInjector.getPaymentInfo(CLASS_NAME);
	}

	@Override public String getClassName() {
		return CLASS_NAME;
	}

	@Override public boolean pay() {
		return true;
	}
}
