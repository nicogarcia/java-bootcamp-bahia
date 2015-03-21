package com.globant.app.services;

import com.globant.app.domain.entities.Payment;
import com.globant.app.domain.paymentMethods.IPaymentMethod;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public interface IPaymentService {

	IPaymentMethod[] getPaymentMethods();

	@Transactional Payment payOrder(Long orderId, IPaymentMethod paymentMethod);
}
