package com.security_blog.yg1110.servicer;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.security_blog.yg1110.domain.User;

public interface UserService extends UserDetailsService {
     Collection<GrantedAuthority> getAuthorities(String username);
//     public User readUser(String username);
     public void createUser(User user);
     public void deleteUser(String username);
     public PasswordEncoder passwordEncoder();
}