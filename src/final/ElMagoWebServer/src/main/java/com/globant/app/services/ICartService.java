package com.globant.app.services;

import com.globant.app.domain.entities.carts.Cart;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public interface ICartService {

	@Transactional
	<S extends Cart> S save(S s);

}
