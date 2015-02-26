package com.globant.app.Domain.Events;

import java.util.Date;

public abstract class Event implements IEvent {
	protected Date date;

	public Event() {
		this.date = new Date();
	}
}
