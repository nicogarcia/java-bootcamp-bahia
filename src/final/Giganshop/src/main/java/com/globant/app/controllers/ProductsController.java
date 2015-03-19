package com.globant.app.controllers;

import com.globant.app.domain.entities.items.Product;
import com.globant.app.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductsController {

	@Autowired
	private IProductService productService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<Product>> findAll() {
		return new ResponseEntity<Iterable<Product>>(productService.findAll(), HttpStatus.OK);
	}

	@RequestMapping("/search/{name}")
	public ResponseEntity<Iterable<Product>> searchByName(@PathVariable String name) {
		return new ResponseEntity<Iterable<Product>>(productService.findByNameIgnoreCaseContaining(name), HttpStatus.OK);
	}

	@RequestMapping("/search/category/{categoryName}")
	public ResponseEntity<Iterable<Product>> searchByCategory(@PathVariable String categoryName) {
		return new ResponseEntity<Iterable<Product>>(productService.findByCategoryName(categoryName), HttpStatus.OK);
	}
}

