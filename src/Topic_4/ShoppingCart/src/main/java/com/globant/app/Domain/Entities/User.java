package com.globant.app.Domain.Entities;

public class User {
	private String username;
	private String password;

	private Cart storedCart;
	private int id;

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Cart getStoredCart() {
		return storedCart;
	}

	public void setStoredCart(Cart storedCart) {
		this.storedCart = storedCart;
	}

	public int getId() {
		return id;
	}
}
