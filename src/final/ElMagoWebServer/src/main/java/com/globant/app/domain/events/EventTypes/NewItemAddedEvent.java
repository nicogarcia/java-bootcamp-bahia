package com.globant.app.domain.events.EventTypes;

import com.globant.app.domain.entities.items.Product;
import com.globant.app.domain.events.Event;

public class NewItemAddedEvent extends Event {

	private Product product;

	public NewItemAddedEvent(Product product) {
		this.product = product;
	}

	public String getDescription() {
		return "[" + this.date + "]\nNew item added:\n" + product.toString();
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
