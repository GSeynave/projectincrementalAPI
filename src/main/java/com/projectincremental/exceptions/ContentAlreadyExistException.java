package com.projectincremental.exceptions;

public class ContentAlreadyExistException extends Exception {

	public ContentAlreadyExistException(String errorMessage) {
		super(errorMessage);
	}

	public ContentAlreadyExistException(String errorMessage, Throwable e) {
		super(errorMessage, e);
	}
}
