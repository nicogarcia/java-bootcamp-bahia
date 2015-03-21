package com.globant.app.domain.paymentMethods;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.stereotype.Component;

@Component
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
		@JsonSubTypes.Type(value = CashPayment.class, name = CashPayment.CLASS_NAME),
		@JsonSubTypes.Type(value = PaypalPayment.class, name = PaypalPayment.CLASS_NAME),
		@JsonSubTypes.Type(value = CreditCardPayment.class, name = CreditCardPayment.CLASS_NAME)
})

public interface IPaymentMethod {

	@JsonIgnore
	String getClassName();

	PaymentInfo getPaymentInfo();

	void setPaymentInfo(PaymentInfo paymentInfo);

	boolean pay();
}
