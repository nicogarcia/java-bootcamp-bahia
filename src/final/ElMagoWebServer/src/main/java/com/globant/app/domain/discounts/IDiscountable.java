package com.globant.app.domain.discounts;

/**
 * Defines the methods for an object that can have a discount
 */
public interface IDiscountable {

	public boolean hasDiscount();

	public DiscountInfo getDiscount();
}
