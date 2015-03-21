package com.globant.app.services.implementations;

import com.globant.app.domain.entities.carts.Cart;
import com.globant.app.domain.entities.Customer;
import com.globant.app.persistence.repositories.ICartRepo;
import com.globant.app.persistence.repositories.ICustomerRepo;
import com.globant.app.services.IAuthenticationService;
import com.globant.app.services.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CartService implements ICartService {

	@Autowired
	private ICartRepo cartRepo;

	@Autowired
	private IAuthenticationService authenticationService;

	@Autowired
	private ICustomerRepo customerRepo;

	@Transactional
	@Override public <S extends Cart> S save(S cart) {

		Customer customer = authenticationService.getCurrentCustomer();

		// Set user as cart user
		cart.setCustomer(customer);

		// Save cart
		cartRepo.save(cart);

		// Set cart as current customer cart
		customer.setCart(cart);

		// Save customer
		customerRepo.save(customer);

		return cart;
	}

}
