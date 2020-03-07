package com.security_blog.yg1110.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.security_blog.yg1110.domain.User;
import com.security_blog.yg1110.servicer.IUserService;

@RestController
public class UserRestController {

	@Autowired
	private IUserService userservice;

    // 이메일 중복체크
    @PostMapping("/user/signup/email_duplicate_check")
    @ResponseBody
    public boolean email_duplicate_check(User user) {
    	return userservice.email_duplicate_check(user) == null ? true : false;
    }
}