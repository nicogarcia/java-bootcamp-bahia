package com.globant.app.domain.events.EventTypes;

import com.globant.app.domain.entities.items.Offer;
import com.globant.app.domain.events.Event;

public class NewOfferAddedEvent extends Event {

	private Offer item;

	public NewOfferAddedEvent(Offer offer) {
		this.item = offer;
	}

	public String getDescription() {
		return "[" + this.date + "]\nNew offer added:\n" + item.toString();
	}

	public Offer getItem() {
		return item;
	}

	public void setItem(Offer item) {
		this.item = item;
	}
}
