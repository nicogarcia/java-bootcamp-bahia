package com.globant.app.services;

import com.globant.app.domain.entities.items.Product;
import org.springframework.stereotype.Service;

@Service
public interface IProductService {
	Product findOne(Long aLong);

	Iterable<Product> findAll();

	Iterable<Product> findByNameIgnoreCaseContaining(String name);

	Iterable<Product> findByCategoryName(String categoryName);
}
