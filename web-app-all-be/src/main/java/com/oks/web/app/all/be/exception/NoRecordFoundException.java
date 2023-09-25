package com.oks.web.app.all.be.exception;

public class NoRecordFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public NoRecordFoundException(String errorMessage) {
		super(errorMessage);
	}
}
