package com.globant.app.Domain.Events.EventTypes;

import com.globant.app.Domain.Entities.Offer;
import com.globant.app.Domain.Events.Event;

public class NewOfferAddedEvent extends Event {

	private Offer item;

	public NewOfferAddedEvent(Offer offer) {
		this.item = offer;
	}

	public String getDescription() {
		return "[" + this.date + "]\nNew offer added:\n" + item.toString();
	}
}
