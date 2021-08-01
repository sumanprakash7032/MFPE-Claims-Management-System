package com.cognizant.authorizationService.exception;


/**
 * This exception class is called when system encountered incorrect
 * username and password
 */ 
public class LoginException extends Exception {
	
	
	private static final long serialVersionUID = 1L;
	/**
	 * @param exceptionMessage
	 * return exceptioMessage
	 */
	public LoginException(String exceptionMessage) {
		super(exceptionMessage);
	}

}
