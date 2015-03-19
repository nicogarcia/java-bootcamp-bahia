
package com.globant.app.services.implementations;

import com.globant.app.domain.entities.Customer;
import com.globant.app.domain.entities.carts.Cart;
import com.globant.app.domain.exceptions.CustomerDoesNotHaveACartException;
import com.globant.app.domain.exceptions.UserAlreadyExistsException;
import com.globant.app.persistence.repositories.ICartRepo;
import com.globant.app.persistence.repositories.ICustomerRepo;
import com.globant.app.services.IAuthenticationService;
import com.globant.app.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	private ICustomerRepo customerRepo;

	@Autowired
	private ICartRepo cartRepo;

	@Autowired
	private IAuthenticationService authenticationService;

	@Override public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return customerRepo.findByUsername(username);
	}

	@Override public Cart getCustomerCart() {
		Customer customer = authenticationService.getCurrentCustomer();

		Cart cart = cartRepo.findByCustomer(customer);

		if(cart == null)
			throw new CustomerDoesNotHaveACartException();

		return cart;
	}

	@Transactional
	@Override public void addCustomer(Customer customer) {
		Customer existingCustomer = customerRepo.findByUsername(customer.getUsername());

		if(existingCustomer != null)
			throw new UserAlreadyExistsException();

		customer.setEnabled(true);

		customerRepo.save(customer);
	}

}
