package com.globant.app.DataAccess.Repositories.Implementations;

import com.globant.app.DataAccess.Repositories.IOffersRepo;
import com.globant.app.Domain.Entities.Offer;
import com.globant.app.Domain.Events.EventTypes.NewOfferAddedEvent;
import com.globant.app.Domain.Events.EventTypes.OfferPriceChangedEvent;
import com.globant.app.Domain.Events.IEventLogger;

import java.util.Collection;

public class OffersRepo extends Repository<Offer> implements
		IOffersRepo {

	public OffersRepo(IEventLogger eventLogger) {
		super(eventLogger);
	}

	@Override public void add(Offer element) {
		elements.put(element.getId(), element);
		eventLogger.log(new NewOfferAddedEvent(element));
	}

	@Override public void save(Offer element) {
		elements.put(element.getId(), element);

		if (element.isDirtyPrice())
			eventLogger.log(new OfferPriceChangedEvent(element));
	}

	@Override public void add(Collection<Offer> offers) {
		for (Offer offer : offers)
			add(offer);
	}
}
