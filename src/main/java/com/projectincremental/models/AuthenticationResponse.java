package com.projectincremental.models;


public class AuthenticationResponse {

	public AuthenticationResponse(String token) {
		super();
		Token = token;
	}

	private String Token;

	public String getToken() {
		return Token;
	}

	public void setToken(String token) {
		Token = token;
	}

}
