package com.globant.app.controllers;

import com.globant.app.domain.entities.Category;
import com.globant.app.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoriesController {

	@Autowired
	private ICategoryService categoryService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<Category>> findAll() {
		return new ResponseEntity<Iterable<Category>>(categoryService.findAll(), HttpStatus.OK);
	}
}
