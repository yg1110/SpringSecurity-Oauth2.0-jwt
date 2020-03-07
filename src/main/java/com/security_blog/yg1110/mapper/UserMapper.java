package com.security_blog.yg1110.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.security_blog.yg1110.domain.User;

@Mapper
public interface UserMapper {
	public List<User> Userlist();
	public User readUser(String username);
	public List<String> readAuthority(String username);
	public void createUser(User user);
	public void createAuthority(User user);
	public void deleteUser(String username);
	public void deleteAuthority(String username);
	public String email_duplicate_check(User user);
}