package com.security_blog.yg1110.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.security_blog.yg1110.domain.User;
import com.security_blog.yg1110.servicer.UserService;

@Controller
public class UserController {

	@Autowired UserService userservice;

    // 회원가입 처리
    @PostMapping("/signup")
    public String execSignup(User user) {
    	System.out.println(user);
    	List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//		authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		user.setAuthorities(authorities);
    	userservice.createUser(user);
        return "redirect:/user/login";
    }
}