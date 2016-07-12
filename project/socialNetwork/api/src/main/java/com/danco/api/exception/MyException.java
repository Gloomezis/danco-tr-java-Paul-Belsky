package com.danco.api.exception;


/**
 * The Class MyException.
 */
public class MyException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new my exception.
	 */
	public MyException() {
		super();
	}

	/**
	 * Instantiates a new my exception.
	 *
	 * @param message the message
	 */
	public MyException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new my exception.
	 *
	 * @param e the e
	 */
	public MyException(Exception e) {
		super(e);
	}

}
