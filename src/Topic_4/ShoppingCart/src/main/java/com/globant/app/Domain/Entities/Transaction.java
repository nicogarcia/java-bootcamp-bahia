package com.globant.app.Domain.Entities;

import com.globant.app.Domain.Discounts.IDiscount;
import com.globant.app.Domain.Discounts.IDiscountManager;
import com.globant.app.Domain.Events.EventTypes.NewTransactionMadeEvent;
import com.globant.app.Domain.Events.IEventLogger;
import com.globant.app.Domain.Exceptions.InvalidPaymentDataException;
import com.globant.app.Domain.PaymentMethods.IPaymentMethod;
import com.globant.app.Domain.Utilities.TransactionManager;

/**
 * Represents a transaction made by an user to pay the Cart
 * with a payment method, and logs each transaction
 */
public class Transaction {

	private long id;
	private Cart cart;
	private User user;
	private IPaymentMethod paymentType;
	private IDiscountManager discountManager;
	private IEventLogger eventLogger;

	private Transaction(long id, Cart cart, User user, IPaymentMethod paymentType, IDiscountManager discountManager, IEventLogger eventLogger) {
		this.cart = cart;
		this.user = user;
		this.paymentType = paymentType;
		this.id = id;
		this.discountManager = discountManager;
		this.eventLogger = eventLogger;
	}

	public static Transaction createTransaction(Cart cart, User user, IPaymentMethod paymentType, IDiscountManager discountManager, IEventLogger eventLogger) {
		long id = TransactionManager.getNextId();
		return new Transaction(id, cart, user, paymentType, discountManager, eventLogger);
	}

	public Cart execute() {

		// Get discounted cart
		Cart discountedCart = getDiscountedCart();

		// Attempt to pay
		// TODO: Implement according to real payments
		tryToPay(paymentType);

		// Log event
		eventLogger.log(new NewTransactionMadeEvent(this));

		return discountedCart;
	}

	public Cart getDiscountedCart() {
		// Get discount
		IDiscount discount = discountManager.getDiscount(paymentType);

		// Apply discounts
		Cart discountedCart = discount.applyDiscount(cart, paymentType);

		return discountedCart;
	}

	private void tryToPay(IPaymentMethod paymentType) {
		if (!paymentType.pay()) {
			throw new InvalidPaymentDataException(paymentType);
		}
	}

}
