package com.globant.app.services.implementations;

import com.globant.app.domain.entities.Category;
import com.globant.app.persistence.repositories.ICategoryRepo;
import com.globant.app.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	private ICategoryRepo categoryRepo;

	@Override public Iterable<Category> findAll() {
		return categoryRepo.findAll();
	}
}
