package com.projectincremental.exceptions;

public class EntityNotFoundException extends RuntimeException {

	public EntityNotFoundException(String errorMessage) {
		super(errorMessage);
	}

	public EntityNotFoundException(String errorMessage, Throwable e) {
		super(errorMessage, e);
	}
}
