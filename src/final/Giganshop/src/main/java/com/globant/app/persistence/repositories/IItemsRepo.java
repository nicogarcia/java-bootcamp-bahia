package com.globant.app.persistence.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IItemsRepo<T> extends CrudRepository<T, Long> {

	Iterable<T> findByNameIgnoreCaseContaining(String name);

	Iterable<T> findByCategoryName(String categoryName);
}
