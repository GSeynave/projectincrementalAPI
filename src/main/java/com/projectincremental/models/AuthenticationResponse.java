package com.projectincremental.models;


public class AuthenticationResponse {

	public AuthenticationResponse(String token, String userId) {
		super();
		Token = token;
		this.userId = userId;
	}

	private String Token;
	private String userId;

	public String getToken() {
		return Token;
	}

	public void setToken(String token) {
		Token = token;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
