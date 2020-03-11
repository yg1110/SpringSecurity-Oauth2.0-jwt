package com.security_blog.yg1110.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.security_blog.yg1110.domain.Post;
import com.security_blog.yg1110.servicer.IPostService;

@RestController
public class PostRestController {
    
	@Autowired
	private IPostService postService;
	
	@PostMapping("/restwrite")
    public ModelAndView postwrite(Post post, Model model) {
    	postService.postwrite(post);
    	model.addAttribute("post", postService.postlist());
    	return new ModelAndView("postlist");
    }

}