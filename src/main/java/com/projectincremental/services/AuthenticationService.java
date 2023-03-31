package com.projectincremental.services;

import com.projectincremental.exceptions.ContentAlreadyExistException;
import com.projectincremental.models.AuthenticationRequest;
import com.projectincremental.models.AuthenticationResponse;
import com.projectincremental.models.RegisterRequest;

public interface AuthenticationService {

	AuthenticationResponse register(RegisterRequest request) throws ContentAlreadyExistException;
	AuthenticationResponse authenticate(AuthenticationRequest request);
}
