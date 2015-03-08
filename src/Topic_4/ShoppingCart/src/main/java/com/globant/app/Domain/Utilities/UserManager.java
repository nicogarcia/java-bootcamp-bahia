package com.globant.app.Domain.Utilities;

import com.globant.app.Domain.Entities.User;

public class UserManager implements IUserManager {

	private User loggedInUser;
	private User businessManagerUser = new User("admin", "admin");

	@Override public boolean login(String user, String password) {
		// TODO: Dummy login, not validating user
		boolean valid = true;
		loggedInUser = new User(user, password);
		return valid;
	}

	@Override public User getCurrentUser() {
		return loggedInUser;
	}

	@Override public User getBusinessManagerUser() {
		return businessManagerUser;
	}

	@Override public void logout() {
		loggedInUser = null;
	}
}