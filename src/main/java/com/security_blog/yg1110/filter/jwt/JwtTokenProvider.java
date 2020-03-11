package com.security_blog.yg1110.filter.jwt;

import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
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

	@Value("${app.jwtExpirationMin}")
	private int jwtExpirationMin;

	// token 생성
	public String generateToken(Authentication authentication) {
		final JwtBuilder builder = Jwts.builder();
		// JWT Token = Header + Payload + Signagure
		builder.setHeaderParam("typ", "JWT");// 토큰의 타입으로 고정 값
		// Payload 설정 - claim 정보 포함
		builder.setSubject("login-token")// 토큰 제목 설정
		.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * jwtExpirationMin))// 유효기간
		.claim("data", authentication);
		// signature - secret key를 이용한 암호화
		builder.signWith(SignatureAlgorithm.HS256, jwtSecret);
		// 마지막 직렬화 처리
		final String token = builder.compact();
		logger.info("login-token 발행: " + token);
		return token;
	}

	// token 조회
	public Map<String, Object> getTokeninfo(String token) {
		Jws<Claims> claims = null;
        try {
            claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
        } catch (final Exception e) {
            throw new RuntimeException();
        }
//        logger.info("claims : " + claims);
        return claims.getBody();
	}

	// token 유효성 검사
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
