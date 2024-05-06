package com.crudapirest.model;

import lombok.Data;



public class User {

	private String user;
	private String token;

	public User(String user, String token) {
		this.user = user;
		this.token = token;
	}

	public User() {
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
