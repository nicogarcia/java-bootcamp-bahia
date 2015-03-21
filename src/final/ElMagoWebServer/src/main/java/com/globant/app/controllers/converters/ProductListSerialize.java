package com.globant.app.controllers.converters;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import com.globant.app.domain.entities.items.Product;
import com.globant.app.domain.exceptions.ProductNotFoundException;
import com.globant.app.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductListSerialize implements Converter<List<Product>, List<Product>> {

	private static IProductService productService;

	public ProductListSerialize() {
	}

	@Autowired
	public ProductListSerialize(IProductService productService) {
		this.productService = productService;
	}

	@Override public List<Product> convert(List<Product> products) {
		List<Product> productList = new ArrayList<Product>();

		for (Product product : products) {
			Product repoProduct = productService.findOne(product.getId());

			if (repoProduct == null)
				throw new ProductNotFoundException();

			Product copyProduct = new Product(
					repoProduct.getName(),
					repoProduct.getCategory(),
					repoProduct.getPrice()
			);

			productList.add(copyProduct);
		}

		return productList;
	}

	@Override public JavaType getInputType(TypeFactory typeFactory) {
		return typeFactory.constructCollectionType(List.class, Product.class);
	}

	@Override public JavaType getOutputType(TypeFactory typeFactory) {
		return typeFactory.constructCollectionType(List.class, Product.class);
	}
}
