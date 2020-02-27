//package com.security_blog.yg1110.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//import com.security_blog.yg1110.servicer.UserService;
//
//@Configuration
//@Order(1)
//public class SecurityConfig2 extends WebSecurityConfigurerAdapter {
//
//	@Autowired
//	UserService userService;
//		
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//		.antMatchers("/user/social").authenticated()
//		.antMatchers("/**").permitAll()
//        .and()
//        .oauth2Login();
//	}
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userService).passwordEncoder(userService.passwordEncoder());
//	}
//}