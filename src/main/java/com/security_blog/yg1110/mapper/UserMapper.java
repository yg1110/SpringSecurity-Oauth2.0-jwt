package com.security_blog.yg1110.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.security_blog.yg1110.domain.User;

@Mapper
public interface UserMapper {
	@Select("SELECT * FROM user WHERE username = #{username}")
	public User readUser(String username);

//	@Select("SELECT authority_name FROM authority WHERE username = #{username}")
//	public Collection<GrantedAuthority> readAuthority(String username);
	
	@Select("SELECT authority_name FROM authority WHERE username = #{username}")
	public List<String> readAuthority(String username);

	@Insert("INSERT INTO user (username, password, name, isAccountNonExpired, isAccountNonLocked, isCredentialsNonExpired, isEnabled) VALUES (#{username}, #{password}, #{name}, #{isAccountNonExpired}, #{isAccountNonLocked}, #{isCredentialsNonExpired}, #{isEnabled})")
	public void createUser(User user);

	@Insert("INSERT INTO authority (username, authority_name) VALUES <foreach collection='authorities' separator=','> (#{username}, #{authorities.value})</foreach>")
	public void createAuthority(User user);

	@Delete("DELETE FROM user WHERE username = #{username}")
	public void deleteUser(String username);

	@Delete("DELETE FROM authority WHERE username = #{username}")
	public void deleteAuthority(String username);

	// public User readUser(String username);
//    public List<GrantedAuthority> readAuthority(String username);
//    public void createUser(User user);
//    public void createAuthority(User user);
//    public void deleteUser(String username);
//    public void deleteAuthority(String username);
}