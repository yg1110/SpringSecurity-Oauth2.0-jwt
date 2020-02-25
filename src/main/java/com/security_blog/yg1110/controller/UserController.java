package com.security_blog.yg1110.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security_blog.yg1110.domain.User;
import com.security_blog.yg1110.mapper.UserMapper;
import com.security_blog.yg1110.servicer.UserServiceImpl;

@RestController
public class UserController {
	@Autowired
	UserMapper userMapper;

	@Autowired UserServiceImpl userservice;

	@RequestMapping("/")
	public List<User> user_list() {
		return userMapper.Userlist();
	}
	
	@RequestMapping("/{username}")
	public List<String> user_auth(@PathVariable String username) {
		return userMapper.readAuthority(username);
	}
	
	@RequestMapping("/createuser")
	public void createuser() {
		User user = new User("a", "a", "a", true, true, true, true);
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ADMIN"));
		authorities.add(new SimpleGrantedAuthority("USER"));
		user.setAuthorities(authorities);
		userservice.createUser(user);
	}
	
	@RequestMapping("/deleteuser/{username}")
	public void deleteuser(@PathVariable String username) {
		userservice.deleteUser(username);
	}

}