package com.globant.app.persistence.repositories;

import com.globant.app.domain.entities.Customer;
import com.globant.app.domain.entities.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepo extends CrudRepository<Order, Long> {

	Iterable<Order> findByCustomer(Customer customer);
}
