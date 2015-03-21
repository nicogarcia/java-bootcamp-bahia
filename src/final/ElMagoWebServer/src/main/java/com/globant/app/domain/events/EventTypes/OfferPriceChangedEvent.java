package com.globant.app.domain.events.EventTypes;

import com.globant.app.domain.entities.items.Offer;
import com.globant.app.domain.events.Event;

public class OfferPriceChangedEvent extends Event {

	Offer offer;

	public OfferPriceChangedEvent(Offer offer) {
		this.offer = offer;
	}

	@Override public String getDescription() {
		return "[" + this.date + "]\nOffer price changed:\n" + offer.toString();
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}
}
