package com.security_blog.yg1110.filter;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

import com.security_blog.yg1110.handler.OAuth2SuccessHandler;

@EnableWebSecurity
@EnableOAuth2Client
public class OauthFilter {
	@Autowired
	OAuth2ClientContext oauth2ClientContext;

	// properties에 있는 client정보를 가져와 사용합니다.
	@Bean
	@ConfigurationProperties("security.oauth2.client")
	OAuth2ProtectedResourceDetails googleclient() {
		return new AuthorizationCodeResourceDetails();
	}

	// properties에 있는 resource정보를 가져와 사용합니다.
	@Bean
	@ConfigurationProperties("security.oauth2.resource")
	ResourceServerProperties googleResource() {
		return new ResourceServerProperties();
	}

	public Filter ssoFilter() {
		OAuth2ClientAuthenticationProcessingFilter googleFilter = new OAuth2ClientAuthenticationProcessingFilter(
				"/social_Login"); // 해당 경
		OAuth2RestTemplate googleTemplate = new OAuth2RestTemplate(googleclient(), oauth2ClientContext);
		googleFilter.setRestTemplate(googleTemplate);
		googleFilter.setTokenServices(
				new UserInfoTokenServices(googleResource().getUserInfoUri(), googleclient().getClientId()));
		googleFilter.setAuthenticationSuccessHandler(new OAuth2SuccessHandler());
		return googleFilter;
	}
}
