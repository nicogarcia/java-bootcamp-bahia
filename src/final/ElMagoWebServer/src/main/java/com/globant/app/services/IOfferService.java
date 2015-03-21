package com.globant.app.services;

import com.globant.app.domain.entities.items.Offer;
import org.springframework.stereotype.Service;

@Service
public interface IOfferService {

	Offer findOne(Long aLong);

	Iterable<Offer> findAll();

	Iterable<Offer> findByNameIgnoreCaseContaining(String name);

	Iterable<Offer> findByCategoryName(String categoryName);
}
