package com.globant.app.DataAccess.Repositories.Implementations;

import com.globant.app.DataAccess.Repositories.IUsersRepo;
import com.globant.app.Domain.Entities.User;
import com.globant.app.Domain.Events.IEventLogger;

public class UsersRepo extends Repository<User> implements
		IUsersRepo {

	public UsersRepo(IEventLogger eventLogger) {
		super(eventLogger);
	}

	@Override public void add(User element) {
		// TODO: To be done
	}

	@Override public void save(User element) {
		// TODO: To be done
	}
}
