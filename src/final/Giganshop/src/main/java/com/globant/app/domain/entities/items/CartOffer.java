package com.globant.app.domain.entities.items;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class CartOffer extends CartItem {

	@OneToOne
	private Offer offer;

	public CartOffer() {
	}

	public CartOffer(Offer offer, int quantity) {
		super(quantity);
		this.offer = offer;
	}

	public CartOffer(Offer offer) {
		this.offer = offer;
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	public double getPrice() {
		return hasDiscount() ? getDiscount().getDiscountFunction().calculateDiscount(offer.getPrice()) : offer.getPrice();
	}

}
