package com.security_blog.yg1110.servicer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security_blog.yg1110.domain.User;
import com.security_blog.yg1110.mapper.UserMapper;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserMapper userMapper;
	
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userMapper.readUser(username);
		if(user==null) {
			throw new UsernameNotFoundException(username);
		}
		user.setAuthorities(getAuthorities(username));
		return user;
	}
	
	public Collection<GrantedAuthority> getAuthorities(String username) {
        List<String> string_authorities = userMapper.readAuthority(username);
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (String authority : string_authorities) {
             authorities.add(new SimpleGrantedAuthority(authority));
        }
        return authorities;
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

	@Override
	public String email_duplicate_check(User user) {
		return userMapper.email_duplicate_check(user);
	}

	@Override
	public User email_certified_check(User user) {
		return userMapper.email_certified_check(user);
	}

	@Override
	public void email_certified_update(User user) {
		userMapper.email_certified_update(user);		
	}
}