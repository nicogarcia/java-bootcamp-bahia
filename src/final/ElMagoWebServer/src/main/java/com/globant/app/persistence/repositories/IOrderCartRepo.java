package com.globant.app.persistence.repositories;

import com.globant.app.domain.entities.carts.OrderCart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderCartRepo extends CrudRepository<OrderCart, Long> {
}
