package com.globant.app.persistence.repositories;

import com.globant.app.domain.entities.items.CartOffer;
import org.springframework.stereotype.Repository;

@Repository
public interface ICartOffersRepo extends ICartItemsRepo<CartOffer> {

}
