package com.globant.app.Domain.Events.EventTypes;

import com.globant.app.Domain.Entities.Transaction;
import com.globant.app.Domain.Events.Event;

public class NewTransactionMadeEvent extends Event {

	private Transaction transaction;

	public NewTransactionMadeEvent(Transaction transaction) {
		this.transaction = transaction;
	}

	@Override public String getDescription() {
		// TODO: Add more information to the notification
		return String.format("[%s] New transaction made", this.date);
	}
}
