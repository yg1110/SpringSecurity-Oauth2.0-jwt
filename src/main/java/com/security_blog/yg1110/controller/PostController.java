package com.security_blog.yg1110.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;

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
	public String postwrite(Post post, @RequestPart MultipartFile files) {
		if(files != null) {
			try {
				String baseDir = "/Users/jeong-yeong-gil/Desktop/SpringSecurity-Oauth2.0-jwt/src/main/resources/static/img";
				files.transferTo(new File(baseDir + "/" + files.getOriginalFilename()));
				InputStream is = new FileInputStream(baseDir + "/" + files.getOriginalFilename());
				BufferedImage img = ImageIO.read(is);
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				ImageIO.write(img, "png", bos);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(files.getOriginalFilename());
		}
		System.out.println(files);
		System.out.println(post);
		postService.postwrite(post);
		return "redirect:/post/list";
	}

	@GetMapping("/post/single/{post_id}")
	public String post(@PathVariable int post_id, Model model) {
		model.addAttribute("post", postService.post(post_id));
		return "post";
	}

}