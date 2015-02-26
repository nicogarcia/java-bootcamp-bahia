package com.globant.app.Domain.Events;

/**
 * Defines the methods for logging an event
 */
public interface IEventLogger {

	public void log(IEvent event);
}
