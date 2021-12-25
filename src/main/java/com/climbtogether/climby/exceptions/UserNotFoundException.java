package com.climbtogether.climby.exceptions;

public class UserNotFoundException extends Exception{

	private static final long serialVersionUID = 3372433440605161397L;
	
	public UserNotFoundException() {
		super();
	}
	public UserNotFoundException(String message) {
		super(message);
	}
	
	

}
