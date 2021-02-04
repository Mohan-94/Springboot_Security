package com.app.domain;

import org.springframework.http.HttpStatus;

public class GenricException extends Exception {

	private static final long serialVersionUID = 1L;
	private String message;
	private HttpStatus status;
	private Throwable exception;

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public Throwable getException() {
		return exception;
	}

	public void setException(Throwable exception) {
		this.exception = exception;
	}

	public GenricException(Throwable cause) {
		super(cause);
	}

	public GenricException(HttpStatus status, String message) {
		this.status = status;
		this.message = message;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ApiException [message=");
		builder.append(message);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}

}
