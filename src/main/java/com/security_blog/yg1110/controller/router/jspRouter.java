package com.security_blog.yg1110.controller.router;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class jspRouter implements WebMvcConfigurer {

	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/user/login").setViewName("login");
		registry.addViewController("/user/login/result").setViewName("index");
		registry.addViewController("/user/logout/result").setViewName("logout");
		registry.addViewController("/user/denied").setViewName("denied");
		registry.addViewController("/user/info").setViewName("info");
		registry.addViewController("/user/admin").setViewName("admin");
		registry.addViewController("/user/signup").setViewName("signup");
		registry.addViewController("/post/write").setViewName("postwrite");
		registry.addViewController("/post/file").setViewName("file");
		registry.addViewController("/img").setViewName("file2");

	}
}