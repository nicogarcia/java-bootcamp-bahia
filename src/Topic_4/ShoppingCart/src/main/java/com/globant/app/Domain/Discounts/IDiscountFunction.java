package com.globant.app.Domain.Discounts;

/**
 * Defines the function to calculate the discount of an object
 */
public interface IDiscountFunction {

	double calculateDiscount(double currentPrice);
}

