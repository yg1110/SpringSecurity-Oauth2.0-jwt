package com.security_blog.yg1110.servicer;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security_blog.yg1110.domain.User;
import com.security_blog.yg1110.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
    
     @Autowired UserMapper userMapper;
     private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

     @Override
     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	 System.out.println(username);
          User user = userMapper.readUser(username);
          user.setAuthorities(getAuthorities(username));
         
          return user;
     }
    
     public Collection<GrantedAuthority> getAuthorities(String username) {
          Collection<GrantedAuthority> authorities = userMapper.readAuthority(username);
         
          return authorities;
     }
    
     @Override
     public User readUser(String username) {
          User user = userMapper.readUser(username);
          user.setAuthorities(userMapper.readAuthority(username));
          return user;
     }

     @Override
     public void createUser(User user) {
          String rawPassword = user.getPassword();
          String encodedPassword = new BCryptPasswordEncoder().encode(rawPassword);
          user.setPassword(encodedPassword);
          userMapper.createUser(user);
          userMapper.createAuthority(user);
     }

     @Override
     public void deleteUser(String username) {
          userMapper.deleteUser(username);
          userMapper.deleteAuthority(username);
     }


     @Override
     public PasswordEncoder passwordEncoder() {
          return this.passwordEncoder;
     }
}