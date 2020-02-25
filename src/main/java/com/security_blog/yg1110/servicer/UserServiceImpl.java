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
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("1 : " + username);
		User user = userMapper.readUser(username);
		System.out.println("2 : " + user);
		if(user==null) {
			throw new UsernameNotFoundException(username);
		}
		user.setAuthorities(getAuthorities(username));
		return user;
	}

//	public Collection<GrantedAuthority> getAuthorities(String username) {
//		System.out.println("3 : " + username);
//		Collection<GrantedAuthority> authorities = userMapper.readAuthority(username);
//		System.out.println("4 : " + authorities);
//		return authorities;
//	}
	
	public Collection<GrantedAuthority> getAuthorities(String username) {
        List<String> string_authorities = userMapper.readAuthority(username);
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (String authority : string_authorities) {
             authorities.add(new SimpleGrantedAuthority(authority));
        }
        System.out.println("3 : " + authorities);
        return authorities;
   }

//	@Override
//	public User readUser(String username) {
//		User user = userMapper.readUser(username);
//		System.out.println("readUser : " + user);
//		user.setAuthorities(userMapper.readAuthority(username));
//		return user;
//	}

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