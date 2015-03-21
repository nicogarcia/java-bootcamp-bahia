package com.globant.app.persistence.repositories;

import com.globant.app.domain.entities.Customer;
import com.globant.app.domain.entities.carts.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICartRepo extends CrudRepository<Cart, Long> {

	Cart findByCustomer(Customer customer);
}
