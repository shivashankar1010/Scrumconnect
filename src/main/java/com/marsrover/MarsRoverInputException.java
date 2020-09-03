package com.marsrover;

/**
 * A custom exception class to throw meaning full context to the users. 
 * 
 * @author Shiva
 */
public class MarsRoverInputException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Only exception.
	 * 
	 * @param exception
	 */
	public MarsRoverInputException(Exception exception) {
		super(exception);
	}

	/**
	 * Exception with custom message.
	 * 
	 * @param message
	 */
	public MarsRoverInputException(String message) {
		super(message);
	}

	/**
	 * Custom message and the cause.
	 * 
	 * @param message
	 * @param cause
	 */
	public MarsRoverInputException(String message, Throwable cause) {
		super(message, cause);
	}

}
