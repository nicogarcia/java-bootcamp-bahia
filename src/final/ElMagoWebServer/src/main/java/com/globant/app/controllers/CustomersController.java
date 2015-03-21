package com.globant.app.controllers;

import com.globant.app.domain.entities.Customer;
import com.globant.app.domain.entities.carts.Cart;
import com.globant.app.services.ICartService;
import com.globant.app.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomersController {

	@Autowired
	private ICartService cartService;

	@Autowired
	private ICustomerService customerService;

	@Secured({ "ROLE_USER" })
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public ResponseEntity<Cart> getCart() {
		return new ResponseEntity<Cart>(customerService.getCustomerCart(), HttpStatus.OK);
	}

	@Secured({ "ROLE_USER" })
	@RequestMapping(value = "/cart", method = RequestMethod.POST)
	public ResponseEntity<Void> saveCart(@RequestBody Cart cart) {

		cartService.save(cart);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<Void> register(@RequestBody Customer customer) {

		customerService.addCustomer(customer);

		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

}
