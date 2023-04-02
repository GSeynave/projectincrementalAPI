package com.projectincremental.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectincremental.dtos.ErrorMessage;
import com.projectincremental.exceptions.ContentAlreadyExistException;
import com.projectincremental.models.AuthenticationRequest;
import com.projectincremental.models.AuthenticationResponse;
import com.projectincremental.models.RegisterRequest;
import com.projectincremental.services.AuthenticationService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
	private final AuthenticationService service;

	Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
	public AuthenticationController(AuthenticationService service) {
		super();
		this.service = service;
	}

	@ApiOperation(value = "Create new account")
	@ApiResponses({ @ApiResponse(code = 201, message = "Success"),
			@ApiResponse(code = 409, message = "Account already exist with provided informations", response = ErrorMessage.class) })
	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) throws ContentAlreadyExistException {
		return ResponseEntity.ok(service.register(request));
	}

	@ApiOperation(value = "Connection")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 401, message = "Credentials are incorrect", response = ErrorMessage.class) })
	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthenticationRequest request) {
		return ResponseEntity.ok(service.authenticate(request));
	}
}
