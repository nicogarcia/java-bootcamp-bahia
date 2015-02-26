package com.globant.app.Domain.Events.EventTypes;

import com.globant.app.Domain.Entities.Offer;
import com.globant.app.Domain.Events.Event;

public class OfferPriceChangedEvent extends Event {

	Offer offer;

	public OfferPriceChangedEvent(Offer offer) {
		this.offer = offer;
	}

	@Override public String getDescription() {
		return "[" + this.date + "]\nOffer price changed:\n" + offer.toString();
	}
}
