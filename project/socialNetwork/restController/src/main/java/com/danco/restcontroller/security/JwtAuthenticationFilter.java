package com.danco.restcontroller.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import com.danco.restcontroller.security.exception.JwtTokenMissingException;



/**
 * The Class JwtAuthenticationFilter.
 */
public class JwtAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    /** The Constant NO_JWT_TOKEN_FOUND_IN_REQUEST_HEADERS. */
    private static final String NO_JWT_TOKEN_FOUND_IN_REQUEST_HEADERS = "No JWT token found in request headers";
	
	/** The Constant BEARER. */
	private static final String BEARER = "Bearer ";
	
	/** The Constant AUTHORIZATION. */
	private static final String AUTHORIZATION = "Authorization";
	
	/** The Constant DEFAULT_FILTER_PROCESSES_URL. */
	private static final String DEFAULT_FILTER_PROCESSES_URL = "/**";

	/**
	 * Instantiates a new jwt authentication filter.
	 */
	public JwtAuthenticationFilter() {
        super(DEFAULT_FILTER_PROCESSES_URL);
    }

    /* (non-Javadoc)
     * @see org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter#requiresAuthentication(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected boolean requiresAuthentication(HttpServletRequest request, HttpServletResponse response) {
        return true;
    }

    /* (non-Javadoc)
     * @see org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter#attemptAuthentication(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String header = request.getHeader(AUTHORIZATION);
        if (header == null || !header.startsWith(BEARER)) {
            throw new JwtTokenMissingException(NO_JWT_TOKEN_FOUND_IN_REQUEST_HEADERS);
        }
        String authToken = header.substring(7);
        JwtAuthenticationToken authRequest = new JwtAuthenticationToken(authToken);
        return getAuthenticationManager().authenticate(authRequest);
    }

    /* (non-Javadoc)
     * @see org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter#successfulAuthentication(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, javax.servlet.FilterChain, org.springframework.security.core.Authentication)
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult)
            throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        chain.doFilter(request, response);
    }
}