package com.security_blog.yg1110.mapper;

import java.util.Collection;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.security.core.GrantedAuthority;

import com.security_blog.yg1110.domain.User;

@Mapper
public interface UserMapper {
	@Select("SELECT * FROM user WHERE username = #{username}")
	public User readUser(String username);

	@Select("SELECT authority_name FROM authority WHERE username = #{username}")
    public Collection<GrantedAuthority> readAuthority(String username);
    
	@Insert("INSERT INTO security_blog.user (username, password, name, isAccountNonExpired, isAccountNonLocked, isCredentialsNonExpired, isEnabled) VALUES (#{username}, #{password}, #{name}, #{isAccountNonExpired}, #{isAccountNonLocked}, #{isCredentialsNonExpired}, #{isEnabled})")
	public void createUser(User user);
	
	@Insert("INSERT INTO authority (username, authority_name) VALUES <foreach item='authority' (#{username}, #{item.authority})</foreach>")
	public void createAuthority(User user);

	@Delete("DELETE FROM security_blog.user WHERE username = #{username}")
	public void deleteUser(String username);

	@Delete("DELETE FROM authority WHERE username = #{username}")
	public void deleteAuthority(String username);
}