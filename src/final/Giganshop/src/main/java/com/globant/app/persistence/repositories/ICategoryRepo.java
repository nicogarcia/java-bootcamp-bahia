package com.globant.app.persistence.repositories;

import com.globant.app.domain.entities.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepo extends CrudRepository<Category, Long> {
}
