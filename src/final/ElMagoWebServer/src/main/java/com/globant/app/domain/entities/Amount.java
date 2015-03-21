package com.globant.app.domain.entities;

import com.globant.app.domain.discounts.DiscountInfo;
import com.globant.app.domain.discounts.IDiscountable;

/**
 * Represents an amount that can have a discount
 */
public class Amount implements IDiscountable {

	private double amount;
	private double undiscountedAmount;
	private DiscountInfo discountInfo;

	public Amount(double undiscountedAmount) {
		this.undiscountedAmount = undiscountedAmount;
	}

	public Amount(double undiscountedAmount, DiscountInfo discountInfo) {
		this.undiscountedAmount = undiscountedAmount;
		this.discountInfo = discountInfo;
	}

	public double getUndiscountedAmount() {
		return undiscountedAmount;
	}

	public double getAmount() {
		return hasDiscount() ? getDiscount().getDiscountFunction().calculateDiscount(undiscountedAmount) : undiscountedAmount;
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

	public void setUndiscountedAmount(double undiscountedAmount) {
		this.undiscountedAmount = undiscountedAmount;
	}
}
