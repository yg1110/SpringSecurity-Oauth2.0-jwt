package com.security_blog.yg1110.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.security_blog.yg1110.servicer.UserService;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserService userService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/admin/**").access("hasAuthority('ADMIN')")
			.antMatchers("/user/myinfo").access("hasAuthority('USER')") // 페이지 권한 설정
			.antMatchers("/**").permitAll()
			.and()
			.formLogin().loginPage("/user/loginPage")
			.loginProcessingUrl("/login")
			.defaultSuccessUrl("/user/login/result")
			.permitAll() // 로그인 설정
			.and()
			.logout().logoutRequestMatcher(new AntPathRequestMatcher("/user/logout")) // 로그아웃 설정
			.logoutSuccessUrl("/user/logout/result").invalidateHttpSession(true)
			.and()
			.exceptionHandling().accessDeniedPage("/user/denied") // 403 예외처리 핸들링
			.and()
			.csrf().disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(userService.passwordEncoder());
	}
}