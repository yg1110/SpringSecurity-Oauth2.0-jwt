package com.security_blog.yg1110.filter.jwt;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private JwtTokenProvider tokenProvider;

	private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String validateToken = (String) session.getAttribute("Authorization");

		// 토큰이 발급되어 있을 경우
		if(validateToken != null) {
			// 토큰기간이 유효
			if(tokenProvider.validateToken(validateToken)) {
				Map<String, Object> resultMap = new HashMap<>();
				try {
					resultMap.putAll(tokenProvider.getTokeninfo(validateToken));
				} catch (RuntimeException e) {
					logger.error("정보조회 실패", e.getMessage());
				}
			}
			// 토큰기간이 만료
			else {
				// 필터를 거치면서 로그인 정보를 null로 만들어버려서 로그인 안한상태로 판단하도록
				SecurityContextHolder.getContext().setAuthentication(null);
				// 세션으로 토큰검사하니까 세션도 지우기
				session.removeAttribute("Authorization");
			}
		}
		// 토큰이 발급되어있지 않은 경우
		else {
			Authentication loginuser_info = SecurityContextHolder.getContext().getAuthentication();

			if (loginuser_info != null) {
				try {
					// 토큰발급
					String jwt = tokenProvider.generateToken(loginuser_info);
					// 토큰정보를 세션에 저장
			        session.setAttribute("Authorization", jwt);
				} catch (Exception e) {
					logger.error("Could not set user authentication in security context", e);
				}
			}
		}

		filterChain.doFilter(request, response);
	}
}
