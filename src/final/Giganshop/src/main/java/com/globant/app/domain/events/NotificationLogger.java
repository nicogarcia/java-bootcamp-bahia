package com.globant.app.domain.events;

import org.springframework.stereotype.Component;

/**
 * Logs notifications of the events to the NotificationCenter
 */

@Component
public class NotificationLogger implements IEventLogger {


	public NotificationLogger() {
	}

	@Override public void log(IEvent event) {

		// Create the notification
		//Notification notification = new Notification(userManager.getBusinessManagerUser(), event);

		// Add it to the notification center
		//NotificationCenter.addNotification(notification);
	}
}
