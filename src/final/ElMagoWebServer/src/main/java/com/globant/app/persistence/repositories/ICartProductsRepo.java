package com.globant.app.persistence.repositories;

import com.globant.app.domain.entities.items.CartProduct;
import org.springframework.stereotype.Repository;

@Repository
public interface ICartProductsRepo extends ICartItemsRepo<CartProduct> {

}
