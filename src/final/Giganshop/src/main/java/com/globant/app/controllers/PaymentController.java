package com.globant.app.controllers;

import com.globant.app.domain.entities.Payment;
import com.globant.app.domain.paymentMethods.IPaymentMethod;
import com.globant.app.services.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private IPaymentService paymentService;

	@RequestMapping("")
	public IPaymentMethod[] getPaymentMethods() {
		return paymentService.getPaymentMethods();
	}


	@RequestMapping(value = "/{orderId}", method = RequestMethod.POST)
	@Secured({ "ROLE_USER" })
	public ResponseEntity<Payment> payOrder(@RequestBody IPaymentMethod paymentMethod, @PathVariable Long orderId) {

		Payment payment = paymentService.payOrder(orderId, paymentMethod);

		return new ResponseEntity<Payment>(payment, HttpStatus.OK);
	}

}
