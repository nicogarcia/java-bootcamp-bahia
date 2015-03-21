package com.globant.app.domain.events;

import java.util.Date;

public abstract class Event implements IEvent {
	protected Date date;

	public Event() {
		this.date = new Date();
	}
}
