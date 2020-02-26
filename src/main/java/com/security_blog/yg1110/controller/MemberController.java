package com.security_blog.yg1110.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.security_blog.yg1110.domain.User;
import com.security_blog.yg1110.mapper.UserMapper;
import com.security_blog.yg1110.servicer.UserServiceImpl;

@Controller
public class MemberController {
	@Autowired UserMapper userMapper;

	@Autowired UserServiceImpl userservice;

    // 메인 페이지
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
        return "index";
    }

    // 회원가입 페이지
    @GetMapping("/user/signup")
    public String dispSignup() {
        return "signup";
    }

    // 회원가입 처리
    @PostMapping("/user/signup")
    public String execSignup(User user) {
    	System.out.println(user);
    	List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//		authorities.add(new SimpleGrantedAuthority("ADMIN"));
		authorities.add(new SimpleGrantedAuthority("USER"));
		user.setAuthorities(authorities);
    	userservice.createUser(user);
        return "redirect:/user/login";
    }

    // 로그인 페이지
    @GetMapping("/user/loginPage")
    public String dispLogin() {
        return "login";
    }

    // 로그인 결과 페이지
    @GetMapping("/user/login/result")
    public String dispLoginResult() {
        return "loginSuccess";
    }

    // 로그아웃 결과 페이지
    @GetMapping("/user/logout/result")
    public String dispLogout() {
        return "logout";
    }

    // 접근 거부 페이지
    @GetMapping("/user/denied")
    public String dispDenied() {
        return "denied";
    }

    // 내 정보 페이지
    @GetMapping("/user/info")
    public String dispMyInfo() {
        return "myinfo";
    }

    // 어드민 페이지
    @GetMapping("/user/admin")
    public String dispAdmin() {
        return "admin";
    }
}