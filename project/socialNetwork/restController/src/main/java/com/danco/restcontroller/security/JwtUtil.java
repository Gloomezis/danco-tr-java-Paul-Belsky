package com.danco.restcontroller.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import com.danco.model.User;
import com.danco.restcontroller.security.exception.JwtTokenMissingException;


/**
 * The Class JwtUtil.
 */
public class JwtUtil implements IJwtUtil {

	/** The Constant NO_JWT_TOKEN_FOUND_IN_REQUEST_HEADERS. */
	private static final String NO_JWT_TOKEN_FOUND_IN_REQUEST_HEADERS = "No JWT token found in request headers";
	
	/** The Constant BEARER. */
	private static final String BEARER = "Bearer ";
	
	/** The Constant USER_ID. */
	private static final String USER_ID = "userId";
	
	/** The Constant GLOOM_APP. */
	private static final String GLOOM_APP = "gloomApp";
	
	/** The Constant SECRET. */
	private static final String SECRET=GLOOM_APP;

	/** The property manger. */
	private static JwtUtil propertyManger;

	/**
	 * Gets the single instance of JwtUtil.
	 *
	 * @return single instance of JwtUtil
	 */
	public static JwtUtil getInstance() {
		if (propertyManger == null) {
			propertyManger = new JwtUtil();
		}
		return propertyManger;
	} 
   
	/**
	 * Instantiates a new jwt util.
	 */
	private  JwtUtil() {
	}

	/**
	 * Gets the secret.
	 *
	 * @return the secret
	 */
	public static String getSecret() {
		return SECRET;
	}

    /* (non-Javadoc)
     * @see com.danco.restcontroller.security.IJwtUtil#parseToken(java.lang.String)
     */
    @Override
	public User parseToken(String token) {
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token)
                    .getBody();

            User u = new User();
            u.setUsername(body.getSubject());
            u.setId(Integer.parseInt((String) body.get(USER_ID)));
            return u;
        } catch (JwtException | ClassCastException e) {
            return null;
        }
    }

    
    /* (non-Javadoc)
     * @see com.danco.restcontroller.security.IJwtUtil#generateToken(com.danco.model.User)
     */
    @Override
	public String generateToken(User u) {
        Claims claims = Jwts.claims().setSubject(u.getUsername());
        claims.put(USER_ID, u.getId() + "");
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }
    
    /* (non-Javadoc)
     * @see com.danco.restcontroller.security.IJwtUtil#getUserFromHeader(java.lang.String)
     */
    @Override
    public User getUserFromHeader(String header){
    	if (header == null || !header.startsWith(BEARER)) {
            throw new JwtTokenMissingException(NO_JWT_TOKEN_FOUND_IN_REQUEST_HEADERS);
        }
        String authToken = header.substring(7);
		return parseToken(authToken);
    }
}
