package com.danco.restcontroller.security.exception;

import org.springframework.security.core.AuthenticationException;


/**
 * The Class JwtTokenMissingException.
 */
public class JwtTokenMissingException extends AuthenticationException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new jwt token missing exception.
	 *
	 * @param msg the msg
	 */
	public JwtTokenMissingException(String msg) {
		super(msg);
	}
}
