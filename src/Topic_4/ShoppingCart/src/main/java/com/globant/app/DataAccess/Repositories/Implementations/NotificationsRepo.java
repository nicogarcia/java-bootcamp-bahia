package com.globant.app.DataAccess.Repositories.Implementations;

import com.globant.app.DataAccess.Repositories.INotificationsRepo;
import com.globant.app.Domain.Entities.Notification;
import com.globant.app.Domain.Entities.User;
import com.globant.app.Domain.Events.IEventLogger;

import java.util.Arrays;
import java.util.Collection;

public class NotificationsRepo extends
		Repository<Notification> implements INotificationsRepo {

	public NotificationsRepo(IEventLogger eventLogger) {
		super(eventLogger);
	}

	@Override public void add(Notification element) {
		elements.put(element.getUser().getId(), element);
	}

	@Override public void save(Notification element) {
		elements.put(element.getUser().getId(), element);
	}

	@Override public Collection<Notification> getNotifications(User user) {
		// TODO: Repair when persistence is correctly implemented by an ORM
		Notification notification = elements.get(user.getId());

		return Arrays.asList(notification);
	}
}
