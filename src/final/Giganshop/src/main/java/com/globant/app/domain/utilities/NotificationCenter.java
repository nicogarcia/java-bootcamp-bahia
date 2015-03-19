package com.globant.app.domain.utilities;

import com.globant.app.domain.entities.Notification;
import com.globant.app.domain.entities.User;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class NotificationCenter {

	static Map<User, List<Notification>> usersNotifications = new HashMap<User, List<Notification>>();

	public static List<Notification> getNotifications(
			User user) {
		List<Notification> list = usersNotifications.get(user);

		if (list == null)
			return new LinkedList<Notification>();

		return list;
	}

	public static void addNotification(Notification notification) {
		if (usersNotifications.get(notification.getUser()) == null) {
			usersNotifications.put(notification.getUser(), new LinkedList<Notification>());
		}

		usersNotifications.get(notification.getUser()).add(notification);
	}
}
