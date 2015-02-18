package Topic_1.ShoppingCart.Domain.PaymentMethods;

public class PaypalPayment implements IPaymentMethod {
	String email;
	String password;

	public PaypalPayment(String email, String password) {
		this.email = email;
		this.password = password;
	}

	@Override public boolean pay() {
		return true;
	}
}
