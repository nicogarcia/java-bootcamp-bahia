package com.globant.app.Domain.Events.EventTypes;

import com.globant.app.Domain.Entities.Item;
import com.globant.app.Domain.Events.Event;

public class NewItemAddedEvent extends Event {

	private Item item;

	public NewItemAddedEvent(Item item) {
		this.item = item;
	}

	public String getDescription() {
		return "[" + this.date + "]\nNew item added:\n" + item.toString();
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
}
