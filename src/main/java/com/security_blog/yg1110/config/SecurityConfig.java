package com.security_blog.yg1110.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.security_blog.yg1110.servicer.UserService;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
     @Autowired UserService userService;
     
     @Override
 	protected void configure(HttpSecurity http) throws Exception {
 		http
 			.authorizeRequests()
 				// 루트와 home요청에 대해서는 요청을 허용한다.
 				.antMatchers("/", "/home").permitAll()
 				// 나머지 경로는 사용자 인증이 된 요청에 대해서만 요청을 허용한다.
 				.anyRequest().authenticated()
 				.and()
 			.formLogin()
 			.and()
 			.logout()
 				.permitAll();
 	}

     @Override
     protected void configure(AuthenticationManagerBuilder auth) throws Exception {
          auth.userDetailsService(userService);
     }
}