package com.projectincremental.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.projectincremental.models.dtos.ErrorMessage;

import io.jsonwebtoken.ExpiredJwtException;


@RestControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorMessage handleErrors(EntityNotFoundException e) {
        logger.info("Entity not found "+ e.getMessage());
        return new ErrorMessage(e.getMessage(), "404");
    }
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorMessage handleErrors(Exception e) {
        logger.info("Internal server error exception"+ e.getMessage());
        return new ErrorMessage(e.getMessage(), "500");
	}

	@ExceptionHandler(ContentAlreadyExistException.class)
	@ResponseStatus(value = HttpStatus.CONFLICT)
	@ResponseBody
	public ErrorMessage handleErrors(ContentAlreadyExistException e) {
		logger.info(new StringBuilder().append("Error : ").append(e.getMessage()));
		return new ErrorMessage(e.getMessage(), "409");
	}

	@ExceptionHandler(AuthenticationException.class)
	@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
	@ResponseBody
	public ErrorMessage handleErrors(AuthenticationException e) {
		logger.info(new StringBuilder().append("Error : ").append(e.getMessage()));
		return new ErrorMessage(e.getMessage(), "401");
	}

	@ExceptionHandler(ExpiredJwtException.class)
	@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
	@ResponseBody
	public ErrorMessage handleErrors(ExpiredJwtException e) {
		logger.info(new StringBuilder().append("Error : ").append(e.getMessage()));
		return new ErrorMessage(e.getMessage(), "401");
	}
}
