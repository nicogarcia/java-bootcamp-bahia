package Topic_1.ShoppingCart.Domain.PaymentMethods;

public class CreditCardPayment implements IPaymentMethod {

	String name;
	String creditCardNumber;

	public CreditCardPayment(String name, String creditCardNumber) {
		this.name = name;
		this.creditCardNumber = creditCardNumber;
	}

	@Override public boolean pay() {
		return true;
	}
}
