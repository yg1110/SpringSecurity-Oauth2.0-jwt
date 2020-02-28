package com.security_blog.yg1110.config;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.security_blog.yg1110.handler.OAuth2SuccessHandler;
import com.security_blog.yg1110.servicer.UserService;

@Configuration
@EnableWebSecurity
@EnableOAuth2Client
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserService userService;
	
	@Autowired
	OAuth2ClientContext oauth2ClientContext;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/user/admin/**").access("hasAuthority('ROLE_ADMIN')")
			.antMatchers("/user/myinfo").access("hasAuthority('ROLE_USER')") // 페이지 권한 설정
			.antMatchers("/", "/user/signup", "/user/denied", "/user/logout/result").permitAll()
			.anyRequest().authenticated()
			.and()
			.addFilterBefore(ssoFilter(), BasicAuthenticationFilter.class) // 소셜로그인 설정
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
	
	@Bean
	@ConfigurationProperties("security.oauth2.client")
	OAuth2ProtectedResourceDetails googleclient() {
		return new AuthorizationCodeResourceDetails();
	}
	
	@Bean
	@ConfigurationProperties("security.oauth2.resource")
	ResourceServerProperties googleResource() {
		return new ResourceServerProperties();
	}
	
	private Filter ssoFilter() {
		OAuth2ClientAuthenticationProcessingFilter googleFilter = new OAuth2ClientAuthenticationProcessingFilter("/social_Login");
		OAuth2RestTemplate googleTemplate = new OAuth2RestTemplate(googleclient(), oauth2ClientContext);
		googleFilter.setRestTemplate(googleTemplate);
		googleFilter.setTokenServices(new UserInfoTokenServices(googleResource().getUserInfoUri(), googleclient().getClientId()));
		googleFilter.setAuthenticationSuccessHandler(new OAuth2SuccessHandler());
		return googleFilter;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(userService.passwordEncoder());
	}
}