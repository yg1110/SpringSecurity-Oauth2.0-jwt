package com.security_blog.yg1110.filter.Oauth2;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.filter.CompositeFilter;

import com.security_blog.yg1110.handler.OAuth2SuccessHandler;

@EnableWebSecurity
@EnableOAuth2Client
public class Oauth2Filter {
	@Autowired
	OAuth2ClientContext oauth2ClientContext;

	@Bean
	@ConfigurationProperties("google.client")
	OAuth2ProtectedResourceDetails googleclient() {
		return new AuthorizationCodeResourceDetails();
	}

	@Bean
	@ConfigurationProperties("google.resource")
	ResourceServerProperties googleResource() {
		return new ResourceServerProperties();
	}

	@Bean
	@ConfigurationProperties("facebook.client")
	OAuth2ProtectedResourceDetails facebookclient() {
		return new AuthorizationCodeResourceDetails();
	}

	@Bean
	@ConfigurationProperties("facebook.resource")
	ResourceServerProperties facebookResource() {
		return new ResourceServerProperties();
	}

	public Filter ssoFilter() {
		CompositeFilter filter = new CompositeFilter();
		List<Filter> filters = new ArrayList<>();
		
		OAuth2ClientAuthenticationProcessingFilter googleFilter = new OAuth2ClientAuthenticationProcessingFilter(
				"/login/google");
		OAuth2ClientAuthenticationProcessingFilter facebookFilter = new OAuth2ClientAuthenticationProcessingFilter(
				"/login/facebook");

		filters.add(ssoFilter("/login/google", googleFilter));
		filters.add(ssoFilter("/login/facebook", facebookFilter));
		filter.setFilters(filters);
		return filter;
	}
	
	public Filter ssoFilter(String path, OAuth2ClientAuthenticationProcessingFilter Filter) {
		ResourceServerProperties resource = null;
		OAuth2ProtectedResourceDetails client = null;

		if(path.equals("/login/google")) {
			resource = googleResource();
			client = googleclient();
		}
		else {
			resource = facebookResource();
			client = facebookclient();
		}

		OAuth2RestTemplate Template = new OAuth2RestTemplate(client, oauth2ClientContext);
		Filter.setRestTemplate(Template);
		Filter.setTokenServices(
				new UserInfoTokenServices(resource.getUserInfoUri(), client.getClientId()));
		
		Filter.setAuthenticationSuccessHandler(new OAuth2SuccessHandler());
		
		return Filter;
	}
	
	@Bean
	public FilterRegistrationBean<OAuth2ClientContextFilter> oauth2ClientFilterRegistration(
	    OAuth2ClientContextFilter filter) {
	  FilterRegistrationBean<OAuth2ClientContextFilter> registration = new FilterRegistrationBean<>();
	  registration.setFilter(filter);
	  registration.setOrder(-100);
	  return registration;
	}
}
