package com.globant.app.services.implementations;

import com.globant.app.domain.entities.Order;
import com.globant.app.domain.entities.Payment;
import com.globant.app.domain.exceptions.OrderAlreadyPaidException;
import com.globant.app.domain.exceptions.OrderNotFoundException;
import com.globant.app.domain.paymentMethods.IPaymentMethod;
import com.globant.app.persistence.repositories.IOrderRepo;
import com.globant.app.persistence.repositories.IPaymentRepo;
import com.globant.app.services.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Map;

@Service
public class PaymentService implements IPaymentService {

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private IOrderRepo orderRepo;

	@Autowired
	private IPaymentRepo paymentRepo;

	@Override public IPaymentMethod[] getPaymentMethods() {
		Map<String, IPaymentMethod> paymentBeans = applicationContext.getBeansOfType(IPaymentMethod.class);

		IPaymentMethod[] methods = new IPaymentMethod[paymentBeans.size()];

		paymentBeans.values().toArray(methods);

		return methods;
	}

	@Transactional
	@Override public Payment payOrder(Long orderId, IPaymentMethod paymentMethod) {
		Order order = orderRepo.findOne(orderId);

		// Check if order exists
		if(order == null)
			throw new OrderNotFoundException();

		// Check if it's not already paid
		if(order.isPaid())
			throw new OrderAlreadyPaidException();

		// Check if payment method is the same
		if(!order.getPaymentType().equals(paymentMethod.getClassName()))
			throw new IllegalArgumentException();

		// Execute payment
		boolean paid = paymentMethod.pay();

		Payment payment = new Payment(order);

		paymentRepo.save(payment);

		order.setPaid(paid);

		orderRepo.save(order);

		return payment;
	}
}
