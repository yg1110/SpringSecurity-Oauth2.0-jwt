package com.security_blog.yg1110.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security_blog.yg1110.dto.Home;
import com.security_blog.yg1110.mapper.HomeMapper;

@RestController
public class HomeController {
	@Autowired
	HomeMapper homeMapper;

	@RequestMapping("/")
	public String home() {
		return "Hello World!";
	}

	@RequestMapping("/{name}")
	public Home home(@PathVariable String name) {
		System.out.println(name);
		Home home = homeMapper.readHome(name);
		return home;
	}
}