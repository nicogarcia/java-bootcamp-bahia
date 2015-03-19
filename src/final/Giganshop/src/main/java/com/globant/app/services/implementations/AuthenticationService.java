package com.globant.app.services.implementations;

import com.globant.app.domain.entities.Customer;
import com.globant.app.persistence.repositories.ICustomerRepo;
import com.globant.app.services.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements IAuthenticationService {

	@Autowired
	private ICustomerRepo usersRepo;

	@Secured({ "ROLE_USER" })
	@Override public Customer getCurrentCustomer() {

		String username = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();

		return usersRepo.findByUsername(username);
	}
}
