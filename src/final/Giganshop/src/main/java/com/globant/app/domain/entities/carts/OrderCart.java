package com.globant.app.domain.entities.carts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.globant.app.domain.entities.Amount;
import com.globant.app.domain.entities.items.CartOffer;
import com.globant.app.domain.entities.items.CartProduct;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class stores the instances of the Items selected
 * by the user with their final price.
 */
@Entity
@Access(AccessType.FIELD)
public class OrderCart {

	@Id
	@GeneratedValue
	@JsonIgnore
	private Long id;

	@JsonIgnore
	@Transient
	private double totalAmount;

	@ManyToMany
	List<CartOffer> cartOffers;

	@ManyToMany
	List<CartProduct> cartProducts;

	@Transient
	private Amount amount;

	public OrderCart() {
		cartOffers = new ArrayList<CartOffer>();
		cartProducts = new ArrayList<CartProduct>();
		amount = new Amount(0);
	}

	public Amount getAmount() {
		return amount;
	}

	public void setAmount(Amount amount) {
		this.amount = amount;
	}

	@Access(AccessType.PROPERTY)
	public double getTotalAmount() {
		return getAmount().getAmount();
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
		this.amount.setAmount(totalAmount);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<CartProduct> getCartProducts() {
		return cartProducts;
	}

	public void setCartProducts(List<CartProduct> cartProducts) {
		this.cartProducts = cartProducts;
	}

	public List<CartOffer> getCartOffers() {
		return cartOffers;
	}

	public void setCartOffers(List<CartOffer> cartOffers) {
		this.cartOffers = cartOffers;
	}
}
