package com.globant.app.domain.entities;

import com.globant.app.domain.entities.carts.Cart;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Customer extends User {

	@OneToOne
	private Cart cart;

	public Customer() {
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
}
