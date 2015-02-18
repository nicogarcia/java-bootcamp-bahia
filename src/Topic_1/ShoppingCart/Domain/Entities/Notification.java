package Topic_1.ShoppingCart.Domain.Entities;

import Topic_1.ShoppingCart.Domain.Events.IEvent;

public class Notification {
	int id;
	User user;
	boolean seen;
	IEvent event;

	public Notification(User user, IEvent event) {
		this.user = user;
		this.event = event;
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
