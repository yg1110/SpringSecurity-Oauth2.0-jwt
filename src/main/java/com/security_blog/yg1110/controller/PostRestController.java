package com.security_blog.yg1110.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
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
	
	@PostMapping(value = "/upload")
	public String fileUpload(@RequestPart MultipartFile files, Model model) {
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
		model.addAttribute("image", "/img/" + files.getOriginalFilename());
		return "업로드 성공";
	}

	@RequestMapping(value = "/image", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] getImageByName() throws IOException {

		InputStream is = new FileInputStream("/Users/jeong-yeong-gil/Desktop/SpringSecurity-Oauth2.0-jwt/src/main/resources/static/img/time.js");
		BufferedImage img = ImageIO.read(is);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ImageIO.write(img, "png", bos);
		return bos.toByteArray();
	}

}