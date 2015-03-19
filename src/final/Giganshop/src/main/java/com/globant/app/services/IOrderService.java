package com.globant.app.services;

import com.globant.app.domain.entities.Order;
import org.springframework.stereotype.Service;

@Service
public interface IOrderService {

	Order createOrder(Order order);

	Order findOne(Long aLong);

	Iterable<Order> findAll();

	Iterable<Order> findCurrentUserOrders();

}
