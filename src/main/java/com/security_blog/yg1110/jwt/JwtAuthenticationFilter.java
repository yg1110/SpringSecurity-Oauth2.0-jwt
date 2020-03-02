package com.security_blog.yg1110.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.security_blog.yg1110.servicer.UserService;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private JwtTokenProvider tokenProvider;

	@Autowired
	private UserService userService;

	private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		System.out.println(request.getRequestURI());

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null) {
			System.out.println(auth.getAuthorities());
			System.out.println(auth.getName());
		}

		try {
			String jwt = getJwtFromRequest(request);
			System.out.println(jwt);
//			if (StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt)) {
//				Long userId = tokenProvider.getUserIdFromJWT(jwt);
//
//				UserDetails userDetails = userService.loadUserByUsername(userId);
//				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
//						userDetails, null, userDetails.getAuthorities());
//
//				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//
//				SecurityContextHolder.getContext().setAuthentication(authentication);
//			}
		} catch (Exception e) {
			logger.error("Could not set user authentication in security context", e);
		}

		filterChain.doFilter(request, response);
	}

	// check header from request
	private String getJwtFromRequest(HttpServletRequest request) {
		String Token = request.getHeader("Authorization");
		System.out.println(Token);
		return null;
	}
}
