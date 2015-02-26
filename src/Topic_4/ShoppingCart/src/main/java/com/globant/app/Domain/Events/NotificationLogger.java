package com.globant.app.Domain.Events;

import com.globant.app.Domain.Entities.Notification;
import com.globant.app.Domain.Utilities.IUserManager;
import com.globant.app.Domain.Utilities.NotificationCenter;

/**
 * Logs notifications of the events to the NotificationCenter
 */
public class NotificationLogger implements IEventLogger {

	private IUserManager userManager;

	public NotificationLogger(IUserManager userManager) {

		this.userManager = userManager;
	}

	@Override public void log(IEvent event) {

		// Create the notification
		Notification notification = new Notification(userManager.getBusinessManagerUser(), event);

		// Add it to the notification center
		NotificationCenter.addNotification(notification);
	}
}
