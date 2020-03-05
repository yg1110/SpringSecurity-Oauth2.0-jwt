package com.security_blog.yg1110.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PostController {
	// 메인 페이지
	@RequestMapping(value = "/blog/postlist", method = RequestMethod.GET)
	public String postlist() {
        return "postlist";
    }
	
	@RequestMapping(value = "/blog/postwrite", method = RequestMethod.GET)
	public String postwrite() {
        return "postwrite";
    }

}