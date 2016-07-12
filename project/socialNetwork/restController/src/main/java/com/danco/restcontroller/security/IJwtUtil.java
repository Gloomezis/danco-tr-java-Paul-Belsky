package com.danco.restcontroller.security;

import com.danco.model.User;

/**
 * The Interface IJwtUtil.
 */
public interface IJwtUtil {

	/**
	 * Parses the token.
	 *
	 * @param token the token
	 * @return the user
	 */
	public  User parseToken(String token);

	/**
	 * Generate token.
	 *
	 * @param u the u
	 * @return the string
	 */
	public  String generateToken(User u);

	/**
	 * Gets the user from header.
	 *
	 * @param header the header
	 * @return the user from header
	 */
	public User getUserFromHeader(String header);

}
