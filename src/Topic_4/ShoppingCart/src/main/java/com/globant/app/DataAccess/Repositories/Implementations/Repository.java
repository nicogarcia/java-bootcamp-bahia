package com.globant.app.DataAccess.Repositories.Implementations;

import com.globant.app.DataAccess.Repositories.IRepository;
import com.globant.app.Domain.Events.IEventLogger;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class Repository<T> implements IRepository<T> {

	protected Map<Integer, T> elements;
	protected IEventLogger eventLogger;

	public Repository(IEventLogger eventLogger) {
		this.elements = new HashMap<Integer, T>();
		this.eventLogger = eventLogger;
	}

	@Override public Collection<T> all() {
		return elements.values();
	}

	@Override public T get(int id) {
		return elements.get(id);
	}



}
