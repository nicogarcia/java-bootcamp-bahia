package com.globant.app.Domain.PaymentMethods;

public class CashPayment implements IPaymentMethod {

	@Override public boolean pay() {
		return true;
	}
}
