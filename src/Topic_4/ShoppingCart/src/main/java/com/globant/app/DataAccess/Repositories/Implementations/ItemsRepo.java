package com.globant.app.DataAccess.Repositories.Implementations;

import com.globant.app.DataAccess.Repositories.IItemsRepo;
import com.globant.app.Domain.Entities.Item;
import com.globant.app.Domain.Events.EventTypes.ItemPriceChangedEvent;
import com.globant.app.Domain.Events.EventTypes.NewItemAddedEvent;
import com.globant.app.Domain.Events.IEventLogger;

import java.util.Collection;

public class ItemsRepo extends Repository<Item> implements IItemsRepo {

	public ItemsRepo(IEventLogger eventLogger) {
		super(eventLogger);
	}

	@Override public void add(Item element) {
		elements.put(element.getId(), element);
		eventLogger.log(new NewItemAddedEvent(element));
	}

	@Override public void save(Item element) {
		elements.put(element.getId(), element);

		if (element.isDirtyPrice())
			eventLogger.log(new ItemPriceChangedEvent(element));
	}

	@Override public void add(Collection<Item> items) {
		for (Item item : items)
			add(item);
	}
}
