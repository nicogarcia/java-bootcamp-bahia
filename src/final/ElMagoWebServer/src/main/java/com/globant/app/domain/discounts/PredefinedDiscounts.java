package com.globant.app.domain.discounts;

/**
 * Predefined discount functions and information objects
 */
public class PredefinedDiscounts {

	public static DiscountInfo ninetyPercentDiscount() {
		return new DiscountInfo("¡90% OFF!", new IDiscountFunction() {
			@Override public double calculateDiscount(double currentPrice) {
				return currentPrice * 0.1;
			}
		});
	}

	public static DiscountInfo freeDiscount() {
		return new DiscountInfo("¡Gratis!", new IDiscountFunction() {
			@Override public double calculateDiscount(double currentPrice) {
				return 0;
			}
		});
	}

	public static IDiscountFunction tenPercentDiscount() {
		return new IDiscountFunction() {
			@Override public double calculateDiscount(double currentPrice) {
				return currentPrice * 0.9;
			}
		};
	}
}
