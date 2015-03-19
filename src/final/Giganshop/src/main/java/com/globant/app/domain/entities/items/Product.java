package com.globant.app.domain.entities.items;

import com.globant.app.domain.entities.Category;

import javax.persistence.Entity;

/**
 * Represents an item of the business
 */

@Entity
public class Product extends Item {

	public Product() {
	}

	public Product(String name, double price) {
		super(name, price);
	}

	public Product(String name, Category category, double listPrice) {
		super(name, listPrice, category);
	}
}
