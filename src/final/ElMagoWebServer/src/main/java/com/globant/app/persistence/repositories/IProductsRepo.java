package com.globant.app.persistence.repositories;

import com.globant.app.domain.entities.items.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductsRepo extends IItemsRepo<Product> {

}
