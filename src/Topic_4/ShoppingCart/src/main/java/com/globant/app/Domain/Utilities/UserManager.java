package com.globant.app.Domain.Utilities;

import com.globant.app.Domain.Entities.User;

public class UserManager implements IUserManager {

	private User loggedInUser;
	private User businessManagerUser = new User("admin", "admin");

	@Override public boolean login(User user) {
		// TODO: Dummy login, not validating user
		boolean valid = true;
		loggedInUser = user;
		return valid;
	}

	@Override public User getCurrentUser() {
		return loggedInUser;
	}

	@Override public User getBusinessManagerUser() {
		return businessManagerUser;
	}
}