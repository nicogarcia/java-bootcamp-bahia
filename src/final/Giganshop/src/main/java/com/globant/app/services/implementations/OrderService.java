package com.globant.app.services.implementations;

import com.globant.app.domain.discounts.IDiscount;
import com.globant.app.domain.entities.Order;
import com.globant.app.domain.entities.carts.OrderCart;
import com.globant.app.domain.paymentMethods.IPaymentMethod;
import com.globant.app.domain.transactionScripts.IOrderCartProcessingTS;
import com.globant.app.domain.utilities.PaymentMethodInjector;
import com.globant.app.persistence.repositories.IOrderCartRepo;
import com.globant.app.persistence.repositories.IOrderRepo;
import com.globant.app.services.IAuthenticationService;
import com.globant.app.services.IDiscountService;
import com.globant.app.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class OrderService implements IOrderService {

	@Autowired
	private IOrderRepo orderRepo;

	@Autowired
	private IAuthenticationService authenticationService;

	@Autowired
	private IDiscountService discountService;

	@Autowired
	private IOrderCartRepo orderCartRepo;

	@Autowired
	private IOrderCartProcessingTS orderCartProcessingTS;

	@Transactional
	@Override public Order createOrder(Order order) {

		// Fill user with current user
		order.setCustomer(authenticationService.getCurrentCustomer());

		// Convert Cart to OrderCart
		orderCartProcessingTS.loadOrderCartFromCart(order);

		// Get payment method
		IPaymentMethod paymentMethod = PaymentMethodInjector.getPaymentMethod(order.getPaymentType());

		// Get discount
		IDiscount discount = discountService.getDiscount(paymentMethod);

		// Apply discounts
		OrderCart discountedCart = discount.applyDiscount(order.getOrderCart(), paymentMethod);

		// Process order
		orderCartProcessingTS.processOrderCart(order);

		// Save discounted OrderCart
		orderCartRepo.save(discountedCart);

		return orderRepo.save(order);
	}

	@Override public Order findOne(Long aLong) {
		return orderRepo.findOne(aLong);
	}

	@Override public Iterable<Order> findAll() {
		return orderRepo.findAll();
	}

	@Override public Iterable<Order> findCurrentUserOrders() {
		return orderRepo.findByCustomer(authenticationService.getCurrentCustomer());
	}

}
