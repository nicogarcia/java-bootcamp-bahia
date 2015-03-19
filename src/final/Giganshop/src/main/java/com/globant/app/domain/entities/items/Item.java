package com.globant.app.domain.entities.items;

import com.globant.app.domain.entities.Category;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

/**
 * Represents an item that can be added to the cart
 */

@MappedSuperclass
public abstract class Item implements Comparable<Item> {

	@Id
	@GeneratedValue
	protected Long id;

	protected String name;

	@OneToOne
	protected Category category;

	protected double price;

	public Item(){
	}

	protected Item(String name, double price) {
		this.name = name;
		this.price = price;
	}

	protected Item(String name, double price, Category category) {
		this(name, price);
		this.category = category;
	}

	@Override public int compareTo(Item item) {
		return Double.compare(price, item.getPrice());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
