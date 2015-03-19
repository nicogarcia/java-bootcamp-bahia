package com.globant.app.domain.entities;

import com.globant.app.domain.events.IEvent;

public class Notification {

	private Long id;

	private User user;
	private boolean seen;
	private IEvent event;

	public Notification(User user, IEvent event) {
		this.user = user;
		this.event = event;
		this.seen = false;
	}

	@Override public String toString() {
		return event.getDescription();
	}

	public User getUser() {
		return user;
	}

	public IEvent getEvent() {
		return event;
	}

	public void setEvent(IEvent event) {
		this.event = event;
	}

	public boolean isSeen() {
		return seen;
	}

	public void setSeen(boolean seen) {
		this.seen = seen;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
