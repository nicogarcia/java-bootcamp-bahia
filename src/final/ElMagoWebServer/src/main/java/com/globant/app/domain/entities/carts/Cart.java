package com.globant.app.domain.entities.carts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.globant.app.controllers.converters.OfferListDeserialize;
import com.globant.app.controllers.converters.OfferListSerialize;
import com.globant.app.controllers.converters.ProductListDeserialize;
import com.globant.app.controllers.converters.ProductListSerialize;
import com.globant.app.domain.entities.Customer;
import com.globant.app.domain.entities.items.Offer;
import com.globant.app.domain.entities.items.Product;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class stores the Items selected by the user to buy
 */
@Entity
public class Cart {

	@Id
	@GeneratedValue
	@JsonIgnore
	private Long id;

	@OneToOne
	@JsonIgnore
	private Customer customer;

	@ManyToMany
	@JsonDeserialize(converter = OfferListDeserialize.class)
	@JsonSerialize(converter = OfferListSerialize.class)
	private List<Offer> offers;

	@ManyToMany
	@JsonDeserialize(converter = ProductListDeserialize.class)
	@JsonSerialize(converter = ProductListSerialize.class)
	private List<Product> products;

	public Cart() {
		offers = new ArrayList<Offer>();
		products = new ArrayList<Product>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Offer> getOffers() {
		return offers;
	}

	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
