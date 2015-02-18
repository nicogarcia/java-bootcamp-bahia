package Topic_1.ShoppingCart.Domain.Entities;

import Topic_1.ShoppingCart.Domain.Events.EventTypes.NewTransactionMadeEvent;
import Topic_1.ShoppingCart.Domain.Events.IEventLogger;
import Topic_1.ShoppingCart.Domain.Exceptions.InvalidPaymentDataException;
import Topic_1.ShoppingCart.Domain.Discounts.DiscountManager;
import Topic_1.ShoppingCart.Domain.Discounts.IDiscount;
import Topic_1.ShoppingCart.Domain.PaymentMethods.IPaymentMethod;
import Topic_1.ShoppingCart.Domain.Utilities.TransactionManager;

/**
 * Represents a transaction made by an user to pay the Cart
 * with a payment method, and logs each transaction
 */
public class Transaction {

	long id;
	Cart cart;
	User user;
	IPaymentMethod paymentType;
	IEventLogger eventLogger;

	private Transaction(long id, Cart cart, User user, IPaymentMethod paymentType, IEventLogger eventLogger) {
		this.cart = cart;
		this.user = user;
		this.paymentType = paymentType;
		this.id = id;
		this.eventLogger = eventLogger;
	}

	public static Transaction createTransaction(Cart cart, User user, IPaymentMethod paymentType, IEventLogger eventLogger) {
		long id = TransactionManager.getNextId();
		return new Transaction(id, cart, user, paymentType, eventLogger);
	}

	public Cart execute() {
		// Attempt to pay
		tryToPay(paymentType);

		// Get discount
		IDiscount discount = DiscountManager.getDiscount(paymentType);

		// Apply discounts
		Cart discountResult = discount.applyDiscount(cart, paymentType);

		// Log event
		eventLogger.log(new NewTransactionMadeEvent(this));

		return discountResult;
	}

	private void tryToPay(IPaymentMethod paymentType) {
		if (!paymentType.pay()) {
			throw new InvalidPaymentDataException(paymentType);
		}
	}

}
