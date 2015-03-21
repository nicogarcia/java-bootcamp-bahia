package com.globant.app.controllers;

import com.globant.app.domain.entities.Order;
import com.globant.app.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrdersController {

	@Autowired
	private IOrderService orderService;

	@Secured({ "ROLE_USER" })
	@RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Order> createOrder(@RequestBody Order order) {
		return new ResponseEntity<Order>(orderService.createOrder(order), HttpStatus.CREATED);
	}

	@Secured({ "ROLE_USER" })
	@RequestMapping(value = "/{orderId}", method = RequestMethod.GET)
	public ResponseEntity<Order> getOrder(@PathVariable Long orderId) {
		return new ResponseEntity<Order>(orderService.findOne(orderId), HttpStatus.OK);
	}

	@Secured({ "ROLE_USER" })
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<Order>> findAll() {
		return new ResponseEntity<Iterable<Order>>(orderService.findCurrentUserOrders(), HttpStatus.OK);
	}
}
