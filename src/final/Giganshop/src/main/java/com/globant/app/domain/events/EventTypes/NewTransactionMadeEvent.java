package com.globant.app.domain.events.EventTypes;

import com.globant.app.domain.entities.Order;
import com.globant.app.domain.events.Event;

public class NewTransactionMadeEvent extends Event {

	private Order order;

	public NewTransactionMadeEvent(Order order) {
		this.order = order;
	}

	@Override public String getDescription() {
		// TODO: Add more information to the notification
		return String.format("[%s] New transaction made", this.date);
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
}
