package com.soprasteria.exceptions;

public class GameAlreadyStartedException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public GameAlreadyStartedException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
