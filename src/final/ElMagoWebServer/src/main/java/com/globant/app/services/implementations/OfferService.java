package com.globant.app.services.implementations;

import com.globant.app.domain.entities.items.Offer;
import com.globant.app.persistence.repositories.IOffersRepo;
import com.globant.app.services.IOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfferService implements IOfferService {

	@Autowired
	private IOffersRepo offersRepo;

	@Override public Offer findOne(Long aLong) {
		return offersRepo.findOne(aLong);
	}

	@Override public Iterable<Offer> findAll() {
		return offersRepo.findAll();
	}

	@Override public Iterable<Offer> findByNameIgnoreCaseContaining(String name) {
		return offersRepo.findByNameIgnoreCaseContaining(name);
	}

	@Override public Iterable<Offer> findByCategoryName(String categoryName) {
		return offersRepo.findByCategoryName(categoryName);
	}
}
