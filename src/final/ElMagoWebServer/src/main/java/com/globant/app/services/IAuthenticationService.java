package com.globant.app.services;

import com.globant.app.domain.entities.Customer;
import org.springframework.stereotype.Service;

@Service
public interface IAuthenticationService {

	Customer getCurrentCustomer();
}
