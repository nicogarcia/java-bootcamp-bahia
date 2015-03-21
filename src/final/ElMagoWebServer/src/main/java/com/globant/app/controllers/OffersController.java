package com.globant.app.controllers;

import com.globant.app.domain.entities.items.Offer;
import com.globant.app.services.IOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/offers")
public class OffersController {

	@Autowired
	private IOfferService offerService;

	@RequestMapping(value = "")
	public ResponseEntity<Iterable<Offer>> findAll() {
		return new ResponseEntity<Iterable<Offer>>(offerService.findAll(), HttpStatus.OK);
	}

	@RequestMapping("/search/{name}")
	public ResponseEntity<Iterable<Offer>> searchByName(@PathVariable String name) {
		return new ResponseEntity<Iterable<Offer>>(offerService.findByNameIgnoreCaseContaining(name), HttpStatus.OK);
	}

	@RequestMapping("/search/category/{categoryName}")
	public ResponseEntity<Iterable<Offer>> searchByCategory(@PathVariable String categoryName) {
		return new ResponseEntity<Iterable<Offer>>(offerService.findByCategoryName(categoryName), HttpStatus.OK);
	}


}
