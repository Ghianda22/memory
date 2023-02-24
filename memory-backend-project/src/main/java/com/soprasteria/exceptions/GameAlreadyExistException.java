package com.soprasteria.exceptions;

public class GameAlreadyExistException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public GameAlreadyExistException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
