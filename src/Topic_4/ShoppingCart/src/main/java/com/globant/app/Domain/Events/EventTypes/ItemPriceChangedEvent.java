package com.globant.app.Domain.Events.EventTypes;

import com.globant.app.Domain.Entities.Item;
import com.globant.app.Domain.Events.Event;

public class ItemPriceChangedEvent extends Event {

	private Item item;

	public ItemPriceChangedEvent(Item item) {
		this.item = item;
	}

	@Override public String getDescription() {
		return "[" + this.date + "]\nItem price changed: " + item.toString();
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
}
