package cs174.starsrus.security.jwt;

import java.security.Key;
import java.util.Date;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import cs174.starsrus.security.services.UserDetailsImpl;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SecurityException;

@Component
public class JwtUtils {
	private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

	@Value("${starsrus.app.jwtSecret}")
	private String jwtSecret;

	@Value("${starsrus.app.jwtExpirationMs}")
	private int jwtExpirationMs;

	private Key getSigningKey() {
		byte[] keyBytes = Decoders.BASE64.decode(this.jwtSecret);
		return Keys.hmacShaKeyFor(keyBytes);
	  }
	  

	public String generateJwtToken(Authentication authentication) {

		UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
		Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
	
		System.out.println("======================= SECRET KEY: " + key.toString());

		// return Jwts.builder()
		// 		.setSubject((userPrincipal.getUsername()))
		// 		.setIssuedAt(new Date())
		// 		.setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
		// 		.signWith(SignatureAlgorithm.HS512, jwtSecret)
		// 		.compact();
		return Jwts.builder()
				.setSubject((userPrincipal.getUsername()))
				.setIssuedAt(new Date())
				.setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
				.signWith(getSigningKey())
				.compact();
	}

	public String getUserNameFromJwtToken(String token) {
		// return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
		return Jwts.parserBuilder().setSigningKey(jwtSecret).build().parseClaimsJws(token).getBody().getSubject();

	}

	public boolean validateJwtToken(String authToken) {
		try {
			// Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			System.out.println("============= >>>>>>>>>>> VALIDATE JWT TOKEN" + jwtSecret + " ---- " + authToken);
			Jwts.parserBuilder().setSigningKey(jwtSecret).build().parseClaimsJws(authToken);
			return true;
		} catch (SecurityException e) {
			logger.error("Invalid JWT signature: {}", e.getMessage());
		} catch (MalformedJwtException e) {
			logger.error("Invalid JWT token: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			logger.error("JWT token is expired: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			logger.error("JWT token is unsupported: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			logger.error("JWT claims string is empty: {}", e.getMessage());
		}

		return false;
	}
}
