package com.globant.app.persistence.repositories;

import com.globant.app.domain.entities.Notification;
import com.globant.app.domain.entities.User;

import java.util.Collection;


public interface INotificationsRepo {//extends IRepository<Notification> {

	public Collection<Notification> getNotifications(User user);
}
