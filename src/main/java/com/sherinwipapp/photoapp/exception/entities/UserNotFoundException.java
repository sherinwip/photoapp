package com.sherinwipapp.photoapp.exception.entities;

public class UserNotFoundException {

	private static final long serialVersionUID = -2567475165865818485L;
	private String message;

	public UserNotFoundException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
