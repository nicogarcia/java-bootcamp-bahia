package com.globant.app.persistence.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ICartItemsRepo<T> extends CrudRepository<T, Long> {

}
