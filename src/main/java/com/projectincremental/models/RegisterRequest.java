package com.projectincremental.models;

public class RegisterRequest {

	public RegisterRequest(String email, String password, String username) {
		super();
		this.email = email;
		this.password = password;
		this.username = username;
	}

	private String email;
	private String password;
	private String username;


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
