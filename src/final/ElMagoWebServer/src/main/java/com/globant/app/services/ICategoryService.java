package com.globant.app.services;

import com.globant.app.domain.entities.Category;
import org.springframework.stereotype.Service;

@Service
public interface ICategoryService {

	Iterable<Category> findAll();
}
