package com.globant.app.domain.paymentMethods;

public abstract class PaymentMethod implements IPaymentMethod{

	protected PaymentInfo paymentInfo;

	protected PaymentMethod(){
	}

	@Override public PaymentInfo getPaymentInfo() {
		return paymentInfo;
	}

	public void setPaymentInfo(PaymentInfo paymentInfo) {
		this.paymentInfo = paymentInfo;
	}
}
