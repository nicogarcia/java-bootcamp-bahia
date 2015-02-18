package Topic_1.ShoppingCart.Domain.Discounts;

import Topic_1.ShoppingCart.Domain.Discounts.Types.CashDiscount;
import Topic_1.ShoppingCart.Domain.Discounts.Types.CreditCardDiscount;
import Topic_1.ShoppingCart.Domain.Discounts.Types.PaypalDiscount;
import Topic_1.ShoppingCart.Domain.PaymentMethods.IPaymentMethod;
import Topic_1.ShoppingCart.Domain.PaymentMethods.CashPayment;
import Topic_1.ShoppingCart.Domain.PaymentMethods.CreditCardPayment;
import Topic_1.ShoppingCart.Domain.PaymentMethods.PaypalPayment;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages the bindings between the payment method and discount applied.
 */
public class DiscountManager {

	static Map<Class<? extends IPaymentMethod>, Class<? extends IDiscount>> discountByPaymentMap =
			new HashMap<Class<? extends IPaymentMethod>, Class<? extends IDiscount>>(5);

	static {
		loadBindings();
	}

	public static void loadBindings() {
		bind(CashPayment.class, CashDiscount.class);
		bind(CreditCardPayment.class, CreditCardDiscount.class);
		bind(PaypalPayment.class, PaypalDiscount.class);
	}

	/**
	 * Returns the discount type according to the payment type
	 */
	public static IDiscount getDiscount(IPaymentMethod paymentType) {
		IDiscount discount = null;
		try {
			discount = discountByPaymentMap.get(paymentType.getClass()).newInstance();

		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return discount;
	}

	public static void bind(Class<? extends IPaymentMethod> paymentType, Class<? extends IDiscount> discount) {
		discountByPaymentMap.put(paymentType, discount);
	}
}
