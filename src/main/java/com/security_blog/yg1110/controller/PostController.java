package com.security_blog.yg1110.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.security_blog.yg1110.domain.Post;
import com.security_blog.yg1110.servicer.IPostService;

@Controller
public class PostController {
    
	@Autowired
	private IPostService postService;

	@GetMapping("/post/list")
    public String postlist(Model model) {
		model.addAttribute("post", postService.postlist());
    	return "postlist";
    }
	
	@PostMapping("/write")
    public String postwrite(Post post) {
    	postService.postwrite(post);
    	return "redirect:/post/list";
    }

	@GetMapping("/post/single/{post_id}")
    public String post(@PathVariable int post_id, Model model) {
		model.addAttribute("post", postService.post(post_id));
    	return "post";
    }
	
}