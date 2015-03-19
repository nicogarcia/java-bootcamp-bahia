package com.globant.app.domain.discounts;

/**
 * Defines the function to calculate the discount of an object
 */
public interface IDiscountFunction {

	double calculateDiscount(double currentPrice);
}

