package com.danco.restcontroller.security;

import com.danco.model.User;

public interface IJwtUtil {

	/**
	 * Tries to parse specified String as a JWT token. If successful, returns User object with username, id and role prefilled (extracted from token).
	 * If unsuccessful (token is invalid or not containing all required user properties), simply returns null.
	 * 
	 * @param token the JWT token to parse
	 * @return the User object extracted from specified token or null if a token is invalid.
	 */
	public  User parseToken(String token);

	/**
	 * Generates a JWT token containing username as subject, and userId and role as additional claims. These properties are taken from the specified
	 * User object. Tokens validity is infinite.
	 * 
	 * @param u the user for which the token will be generated
	 * @return the JWT token
	 */
	public  String generateToken(User u);

}
