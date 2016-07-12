package com.danco.restcontroller.security.exception;

import org.springframework.security.core.AuthenticationException;


/**
 * The Class JwtTokenMalformedException.
 */
public class JwtTokenMalformedException extends AuthenticationException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new jwt token malformed exception.
	 *
	 * @param msg the msg
	 */
	public JwtTokenMalformedException(String msg) {
		super(msg);
	}
}
