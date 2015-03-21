package com.globant.app.domain.paymentMethods;

import java.util.ArrayList;
import java.util.List;

public class PaymentInfo {

	private List<PayInfoField> fields;

	public PaymentInfo() {
		fields = new ArrayList<PayInfoField>();
	}

	public PaymentInfo(PaymentInfo paymentInfo) {
		this.fields = paymentInfo.getFields();
	}

	public PaymentInfo(List<PayInfoField> fields) {
		this.fields = fields;
	}

	public List<PayInfoField> getFields() {
		return fields;
	}

	public void setFields(List<PayInfoField> fields) {
		this.fields = fields;
	}
}
