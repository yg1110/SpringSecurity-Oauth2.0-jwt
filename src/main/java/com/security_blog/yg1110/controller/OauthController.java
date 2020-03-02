package com.security_blog.yg1110.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OauthController {
	@RequestMapping(value = "/social_user_info", method = RequestMethod.GET)
	public Object index() {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth);
        return auth;
    }
}
