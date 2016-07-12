package com.danco.restcontroller.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

import com.danco.model.User;
import com.danco.restcontroller.security.exception.JwtTokenMalformedException;


/**
 * The Class JwtAuthenticationProvider.
 */
public class JwtAuthenticationProvider extends
		AbstractUserDetailsAuthenticationProvider {

	/** The Constant JWT_TOKEN_IS_NOT_VALID. */
	private static final String JWT_TOKEN_IS_NOT_VALID = "JWT token is not valid";
	
	/** The jwt util. */
	private IJwtUtil jwtUtil = JwtUtil.getInstance();

	/* (non-Javadoc)
	 * @see org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> authentication) {
		return (JwtAuthenticationToken.class.isAssignableFrom(authentication));
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider#additionalAuthenticationChecks(org.springframework.security.core.userdetails.UserDetails, org.springframework.security.authentication.UsernamePasswordAuthenticationToken)
	 */
	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider#retrieveUser(java.lang.String, org.springframework.security.authentication.UsernamePasswordAuthenticationToken)
	 */
	@Override
	protected UserDetails retrieveUser(String username,
			UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) authentication;
		String token = jwtAuthenticationToken.getToken();
		User parsedUser = jwtUtil.parseToken(token);
		if (parsedUser == null) {
			throw new JwtTokenMalformedException(JWT_TOKEN_IS_NOT_VALID);
		}
		return new User(parsedUser.getId(), parsedUser.getUsername(), token);
	}
}
