package com.globant.app.persistence.repositories;

import com.globant.app.domain.entities.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepo extends CrudRepository<Customer, Long> {

	Customer findByUsername(String username);

}
