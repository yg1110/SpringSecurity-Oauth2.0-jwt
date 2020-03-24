package com.security_blog.yg1110.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

//https://gs.saro.me/dev?tn=520
public class OAuth2SuccessHandler implements AuthenticationSuccessHandler {
	@Override
	public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse res, Authentication auth)
			throws IOException, ServletException {
        System.out.println(auth.getPrincipal());
        System.out.println(auth.isAuthenticated());
        System.out.println(auth.getDetails());
        System.out.println(auth.getCredentials());
        System.out.println(auth.getAuthorities());
        System.out.println(auth.getName());
        
        WebAuthenticationDetails details = (WebAuthenticationDetails) auth.getDetails();
        System.out.println(details);

        res.sendRedirect("/");
	}
}