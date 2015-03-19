package com.globant.app.domain.entities;

import com.globant.app.domain.discounts.DiscountInfo;
import com.globant.app.domain.discounts.IDiscountable;

/**
 * Represents an amount that can have a discount
 */
public class Amount implements IDiscountable {

	private double amount;
	private DiscountInfo discountInfo;

	public Amount(double amount) {
		this.amount = amount;
	}

	public Amount(double amount, DiscountInfo discountInfo) {
		this.amount = amount;
		this.discountInfo = discountInfo;
	}

	public double getUndiscountedAmount() {
		return amount;
	}

	public double getAmount() {
		return hasDiscount() ? getDiscount().getDiscountFunction().calculateDiscount(amount) : amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public DiscountInfo getDiscountInfo() {
		return discountInfo;
	}

	public void setDiscountInfo(DiscountInfo discountInfo) {
		this.discountInfo = discountInfo;
	}

	@Override public boolean hasDiscount() {
		return discountInfo != null;
	}

	@Override public DiscountInfo getDiscount() {
		return discountInfo;
	}
}
