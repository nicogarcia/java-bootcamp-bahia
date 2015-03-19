package com.globant.app.services;

import com.globant.app.domain.entities.Customer;
import com.globant.app.domain.entities.carts.Cart;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public interface ICustomerService extends UserDetailsService {

	Cart getCustomerCart();

	@Transactional void addCustomer(Customer customer);
}
