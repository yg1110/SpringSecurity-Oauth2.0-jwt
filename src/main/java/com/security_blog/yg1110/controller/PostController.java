package com.security_blog.yg1110.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

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

	@PostMapping(value = "/upload")
	public String fileUpload(@RequestPart MultipartFile files, Model model) {
		try {
			String baseDir = "/Users/jeong-yeong-gil/Desktop/SpringSecurity-Oauth2.0-jwt/src/main/resources/static/img";
			files.transferTo(new File(baseDir + "/" + files.getOriginalFilename()));

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(files.getOriginalFilename());
		model.addAttribute("image", "/img/"+files.getOriginalFilename());
		return "file2";
	}

	@GetMapping(value = "/file")
	public String file(Model model) {
		model.addAttribute("image", "/img/응답결과.png");
		return "file2";
	}

}