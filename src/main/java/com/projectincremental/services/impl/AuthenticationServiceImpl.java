package com.projectincremental.services.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.projectincremental.config.JwtService;
import com.projectincremental.models.AuthenticationRequest;
import com.projectincremental.models.AuthenticationResponse;
import com.projectincremental.models.RegisterRequest;
import com.projectincremental.models.Role;
import com.projectincremental.models.UserDocument;
import com.projectincremental.repositories.UserRepository;
import com.projectincremental.services.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtTokenUtil;
	private final AuthenticationManager authenticationManager;

	public AuthenticationServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder,
			JwtService jwtTokenUtil, AuthenticationManager authenticationManager) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtTokenUtil = jwtTokenUtil;
		this.authenticationManager = authenticationManager;
	}

	@Override
	public AuthenticationResponse register(RegisterRequest request) {
		if (userRepository.findByEmail(request.getEmail()).isEmpty()) {
			UserDocument user = new UserDocument();
			user.setEmail(request.getEmail());
			user.setUsername(request.getUsername());
			user.setPassword(passwordEncoder.encode(request.getPassword()));
			user.setRole(Role.USER);
			userRepository.save(user);
			String jwtToken = jwtTokenUtil.generateToken(user);
			return new AuthenticationResponse(jwtToken);
		}
		// throw apiException + custom message;
		System.out.println("already exist");
		return null;
	}

	@Override
	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		UserDocument user = userRepository.findByUsername(request.getUsername()).orElseThrow();
		String jwtToken = jwtTokenUtil.generateToken(user);
		return new AuthenticationResponse(jwtToken);
	}

}
