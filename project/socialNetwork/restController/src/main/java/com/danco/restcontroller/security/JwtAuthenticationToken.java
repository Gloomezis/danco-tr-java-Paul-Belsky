package com.danco.restcontroller.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;


/**
 * The Class JwtAuthenticationToken.
 */
public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {

	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The token. */
	private String token;

	/**
	 * Instantiates a new jwt authentication token.
	 *
	 * @param token the token
	 */
	public JwtAuthenticationToken(String token) {
		super(null, null);
		this.token = token;
	}

	/**
	 * Gets the token.
	 *
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.authentication.UsernamePasswordAuthenticationToken#getCredentials()
	 */
	@Override
	public Object getCredentials() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.authentication.UsernamePasswordAuthenticationToken#getPrincipal()
	 */
	@Override
	public Object getPrincipal() {
		return null;
	}
}