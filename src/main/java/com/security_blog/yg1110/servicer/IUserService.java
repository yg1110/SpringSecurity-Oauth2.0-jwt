package com.security_blog.yg1110.servicer;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.security_blog.yg1110.domain.User;

public interface IUserService extends UserDetailsService {
	public Collection<GrantedAuthority> getAuthorities(String username);
	public void createUser(User user);
	public void deleteUser(String username);
	public PasswordEncoder passwordEncoder();
	public String email_duplicate_check(User user);
	public User email_certified_check(User user);
	public void email_certified_update(User user);
}