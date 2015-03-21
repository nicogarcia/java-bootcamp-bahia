package com.globant.app.controllers.converters;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import com.globant.app.domain.entities.items.Offer;
import com.globant.app.domain.exceptions.OfferNotFoundException;
import com.globant.app.services.IOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OfferListSerialize implements Converter<List<Offer>, List<Offer>> {
	private static IOfferService offerService;

	public OfferListSerialize() {
	}

	@Autowired
	public OfferListSerialize(IOfferService offerService) {
		this.offerService = offerService;
	}

	@Override public List<Offer> convert(List<Offer> offers) {
		List<Offer> offerList = new ArrayList<Offer>();

		for (Offer offer : offers) {
			Offer repoOffer = offerService.findOne(offer.getId());

			if (repoOffer == null)
				throw new OfferNotFoundException();

			Offer copyOffer = new Offer(
					repoOffer.getName(),
					repoOffer.getPrice(),
					repoOffer.getCategory(),
					repoOffer.getProducts()
			);

			offerList.add(copyOffer);
		}

		return offerList;
	}

	@Override public JavaType getInputType(TypeFactory typeFactory) {
		return typeFactory.constructCollectionType(List.class, Offer.class);
	}

	@Override public JavaType getOutputType(TypeFactory typeFactory) {
		return typeFactory.constructCollectionType(List.class, Offer.class);
	}
}
