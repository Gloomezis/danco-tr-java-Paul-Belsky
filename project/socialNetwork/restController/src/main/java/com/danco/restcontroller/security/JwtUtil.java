package com.danco.restcontroller.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import com.danco.model.User;

public class JwtUtil implements IJwtUtil {

   
    private static final String SECRET="gloomApp";

    
    
    public JwtUtil() {
		
	}

	public static String getSecret() {
		return SECRET;
	}

	/* (non-Javadoc)
	 * @see com.danco.security.IJwtUtil#parseToken(java.lang.String)
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
            u.setId(Integer.parseInt((String) body.get("userId")));
           

            return u;

        } catch (JwtException | ClassCastException e) {
            return null;
        }
    }

    /* (non-Javadoc)
	 * @see com.danco.security.IJwtUtil#generateToken(com.danco.model.User)
	 */
    @Override
	public String generateToken(User u) {
        Claims claims = Jwts.claims().setSubject(u.getUsername());
        claims.put("userId", u.getId() + "");
        

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }
}
