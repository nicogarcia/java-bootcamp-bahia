package com.globant.app.domain.transactionScripts;

import com.globant.app.domain.entities.Order;

public interface IOrderCartProcessingTS {
	void loadOrderCartFromCart(Order order);

	void processOrderCart(Order order);
}
