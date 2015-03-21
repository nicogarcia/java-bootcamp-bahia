package com.globant.app.domain.events.EventTypes;

import com.globant.app.domain.entities.items.Product;
import com.globant.app.domain.events.Event;

public class ItemPriceChangedEvent extends Event {

	private Product product;

	public ItemPriceChangedEvent(Product product) {
		this.product = product;
	}

	@Override public String getDescription() {
		return "[" + this.date + "]\nItem price changed: " + product.toString();
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
