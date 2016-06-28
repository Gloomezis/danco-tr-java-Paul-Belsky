package com.danco.restcontroller.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

import com.danco.model.JwtAuthenticationToken;
import com.danco.model.User;
import com.danco.restcontroller.security.exception.JwtTokenMalformedException;

public class JwtAuthenticationProvider extends
		AbstractUserDetailsAuthenticationProvider {

	
	private IJwtUtil jwtUtil =new JwtUtil();

	@Override
	public boolean supports(Class<?> authentication) {
		return (JwtAuthenticationToken.class.isAssignableFrom(authentication));
	}

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
	}

	@Override
	protected UserDetails retrieveUser(String username,
			UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) authentication;
		String token = jwtAuthenticationToken.getToken();

		User parsedUser = jwtUtil.parseToken(token);

		if (parsedUser == null) {
			throw new JwtTokenMalformedException("JWT token is not valid");
		}
		return new User(parsedUser.getId(), parsedUser.getUsername(), token);
	}
}
