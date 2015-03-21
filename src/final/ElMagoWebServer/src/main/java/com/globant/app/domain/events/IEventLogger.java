package com.globant.app.domain.events;

import org.springframework.stereotype.Component;

/**
 * Defines the methods for logging an event
 */

@Component
public interface IEventLogger {

	void log(IEvent event);
}
