package com.globant.app.domain.entities.items;

import com.globant.app.domain.entities.Category;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Represents an offer made over some items
 */

@Entity
public class Offer extends Item {

	@ElementCollection
	private Collection<Product> products;

	public Offer() {
	}

	public Offer(String name, double price) {
		super(name, price);
		products = new ArrayList<Product>();
	}

	public Offer(String name, double listPrice, Category category, Collection<Product> products) {
		super(name, listPrice, category);
		this.products = products;
	}

	public Offer(String name, double listPrice, Category category) {
		super(name, listPrice, category);
	}


	public Collection<Product> getProducts() {
		return products;
	}

	public void setProducts(Collection<Product> products) {
		this.products = products;
	}

	public void addItem(Product item) {
		products.add(item);
	}
}
