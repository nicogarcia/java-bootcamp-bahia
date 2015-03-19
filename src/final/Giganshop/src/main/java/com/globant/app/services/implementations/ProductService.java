package com.globant.app.services.implementations;

import com.globant.app.domain.entities.items.Product;
import com.globant.app.persistence.repositories.IProductsRepo;
import com.globant.app.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

	@Autowired
	private IProductsRepo productsRepo;

	@Override public Product findOne(Long aLong) {
		return productsRepo.findOne(aLong);
	}

	@Override public Iterable<Product> findAll() {
		return productsRepo.findAll();
	}

	@Override public Iterable<Product> findByNameIgnoreCaseContaining(String name) {
		return productsRepo.findByNameIgnoreCaseContaining(name);
	}

	@Override public Iterable<Product> findByCategoryName(String categoryName) {
		return productsRepo.findByCategoryName(categoryName);
	}
}
