package com.security_blog.yg1110.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security_blog.yg1110.domain.User;
import com.security_blog.yg1110.dto.Home;
import com.security_blog.yg1110.mapper.HomeMapper;
import com.security_blog.yg1110.mapper.UserMapper;

@RestController
public class HomeController {
	@Autowired
	HomeMapper homeMapper;

	@Autowired
	UserMapper userMapper;

	@RequestMapping("/")
	public List<String> home() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		System.out.println(bCryptPasswordEncoder.encode("1234"));
		return userMapper.readAuthority("cusonar");
	}

	@RequestMapping("/createduser")
	public void createduser() {
		User user = new User("a", "a", "a", true, true, true, true);
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ADMIN"));
		authorities.add(new SimpleGrantedAuthority("USER"));
		user.setAuthorities(authorities);
		System.out.println(user);
		userMapper.createUser(user);
		userMapper.createAuthority(user);
	}

	@RequestMapping("/{name}")
	public Home home(@PathVariable String name) {
		System.out.println(name);
		Home home = homeMapper.readHome(name);
		return home;
	}
}