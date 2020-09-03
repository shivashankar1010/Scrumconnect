package com.marsrover;

/**
 * A custom exception class to throw meaning full context to the users. 
 * 
 * @author  Shiva
 */
public class InvalidCoordinatesException extends MarsRoverInputException {

	private static final long serialVersionUID = 1L;

	/**
	 * Only exception.
	 * 
	 * @param exception
	 */
	public InvalidCoordinatesException(Exception exception) {
		super(exception);
	}

	/**
	 * Exception with custom message.
	 * 
	 * @param message
	 */
	public InvalidCoordinatesException(String message) {
		super(message);
	}

	/**
	 * Custom message and the cause.
	 * 
	 * @param message
	 * @param cause
	 */
	public InvalidCoordinatesException(String message, Throwable cause) {
		super(message, cause);
	}

}
