package com.dev4abyss.louvorsheknah.exception;

public class AuthException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AuthException(String msg) {
		super(msg);
	}

	public AuthException(String msg, Throwable cause) {
		super(msg, cause);
	}

}