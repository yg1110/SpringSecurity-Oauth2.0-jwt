package com.security_blog.yg1110.config;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.security_blog.yg1110.filter.Oauth2.Oauth2Filter;
import com.security_blog.yg1110.filter.jwt.JwtAuthenticationFilter;
import com.security_blog.yg1110.servicer.IUserService;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private IUserService userService;

	@Autowired
	private Oauth2Filter filter;

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/login/css/**", "/login/js/**", "/login/images/**", "/login/vendor/**", "/login/fonts/**", "/ckeditor/**", "/img/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/user/admin/**").access("hasAuthority('ROLE_ADMIN')")
				.antMatchers("/user/myinfo").access("hasAuthority('ROLE_USER')") // 페이지 권한 설정
				.antMatchers("/user/signup/**", "/user/denied", "/user/logout/result", "/signup", "/user/email/certified").permitAll().anyRequest()
				.authenticated().and().addFilterBefore(ssoFilter(), BasicAuthenticationFilter.class) // 소셜로그인 설정
				.addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter.class) // jwt 필터 설정
				.formLogin().loginPage("/user/login").loginProcessingUrl("/login")
				.defaultSuccessUrl("/", true).permitAll() // 로그인 설정
				.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/user/logout")) // 로그아웃 설정
				.logoutSuccessUrl("/").invalidateHttpSession(true).and().exceptionHandling()
				.accessDeniedPage("/user/denied") // 403 예외처리 핸들링
				.and().csrf().disable();
	}

	@Bean
	public Filter ssoFilter() {
		return filter.ssoFilter();
	}

	@Bean
	public JwtAuthenticationFilter jwtFilter() {
		return new JwtAuthenticationFilter();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(userService.passwordEncoder());
	}
}