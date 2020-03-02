package com.security_blog.yg1110.jwt;

import java.nio.file.attribute.UserPrincipal;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.security_blog.yg1110.domain.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtTokenProvider {
	private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

	@Value("${app.jwtSecret}")
	private String jwtSecret;

	@Value("${app.jwtExpirationMs}")
	private int jwtExpirationMs;
	
	@Value("${app.jwtOwnerExpirationMs}")
	private int jwtOwnerExpirationMs;

	// Token 생성
//	public String generateToken(Authentication authentication, List<String> roles) {
//		User userPrincipal = (UserPrincipal) authentication.getPrincipal();
//
//		boolean isOwner = false;
//		for(String role : roles) {
//			if(role.contains("OWNER")) {
//				isOwner = true;
//				break;
//			}
//		}
//		
//		Date now = new Date(); // 현재 시간
//		Date expiryDate = isOwner ? new Date(now.getTime() + jwtOwnerExpirationMs) :
//				new Date(now.getTime() + jwtExpirationMs); // 토근 만료 시간
//
//		return Jwts.builder().setSubject(Long.toString(userPrincipal.getId())).setIssuedAt(new Date())
//				.setExpiration(expiryDate).signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
//	}

	public Long getUserIdFromJWT(String token) {
		Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();

		return Long.parseLong(claims.getSubject());
	}

	public boolean validateToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException e) {
			logger.error("Invalid JWT signature");
		} catch (MalformedJwtException e) {
			logger.error("Invalid JWT token");
		} catch (ExpiredJwtException e) {
			logger.error("Expired JWT token");
		} catch (UnsupportedJwtException e) {
			logger.error("Unsupported JWT token");
		} catch (IllegalArgumentException e) {
			logger.error("JWT claims string is empty");
		}

		return false;
	}

}
