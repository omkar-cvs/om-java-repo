package com.oks.web.app.all.be.exception;

public class InvalideInputException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public InvalideInputException(String errorMessage) {
		super(errorMessage);
	}
}
