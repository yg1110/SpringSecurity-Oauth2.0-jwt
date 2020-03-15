package com.security_blog.yg1110.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.security_blog.yg1110.domain.User;
import com.security_blog.yg1110.servicer.IPostService;
import com.security_blog.yg1110.servicer.IUserService;

@Controller
public class UserController {

	@Autowired
	private IUserService userservice;

	@Autowired
	private IPostService postservice;

    @GetMapping("/")
    public String index(Model model) {
    	model.addAttribute("post", postservice.postlist());
        return "index";
    }

	
	// 회원가입 처리
    @PostMapping("/signup")
    public String execSignup(User user) {
    	List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//		authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		user.setAuthorities(authorities);
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setCredentialsNonExpired(true);
		user.setEnabled(true);
		user.setCertified(certified_key());
    	userservice.createUser(user);
        return "login";
    }

    private String certified_key() {
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		int num = 0;

		do {
			num = random.nextInt(75) + 48;
			if ((num >= 48 && num <= 57) || (num >= 65 && num <= 90) || (num >= 97 && num <= 122)) {
				sb.append((char) num);
			} else {
				continue;
			}

		} while (sb.length() < 10);
		return sb.toString();
	}

}