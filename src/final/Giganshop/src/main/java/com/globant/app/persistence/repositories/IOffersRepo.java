package com.globant.app.persistence.repositories;

import com.globant.app.domain.entities.items.Offer;
import org.springframework.stereotype.Repository;

@Repository
public interface IOffersRepo extends IItemsRepo<Offer> {

}
