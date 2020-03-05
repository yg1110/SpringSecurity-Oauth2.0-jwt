package com.security_blog.yg1110.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class jspRouter implements WebMvcConfigurer {

	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/user/login").setViewName("login");
		registry.addViewController("/user/login/result").setViewName("index");
		registry.addViewController("/user/logout/result").setViewName("logout");
		registry.addViewController("/user/denied").setViewName("denied");
		registry.addViewController("/user/info").setViewName("info");
		registry.addViewController("/user/admin").setViewName("admin");
		registry.addViewController("/user/signup").setViewName("signup");
		registry.addViewController("/blog/postlist").setViewName("postlist");
		registry.addViewController("/blog/postwrite").setViewName("postwrite");
	}
}