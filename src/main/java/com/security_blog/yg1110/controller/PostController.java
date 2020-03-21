package com.security_blog.yg1110.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.security_blog.yg1110.domain.FileInfo;
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

//	@PostMapping("/write")
//	public String postwrite(Post post, @RequestPart MultipartFile files) {
//		if(files != null) {
//			try {
//				String baseDir = "/Users/jeong-yeong-gil/Desktop/SpringSecurity-Oauth2.0-jwt/src/main/resources/static/img";
//				files.transferTo(new File(baseDir + "/" + files.getOriginalFilename()));
//				InputStream is = new FileInputStream(baseDir + "/" + files.getOriginalFilename());
//				BufferedImage img = ImageIO.read(is);
//				ByteArrayOutputStream bos = new ByteArrayOutputStream();
//				ImageIO.write(img, "png", bos);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			System.out.println(files.getOriginalFilename());
//		}
//		System.out.println(files);
//		System.out.println(post);
//		postService.postwrite(post);
//		return "redirect:/post/list";
//	}

	@PostMapping("/write")
	public String postwrite(Post post, HttpServletRequest request, @RequestPart MultipartFile files) throws Exception{

		if (files != null) {
			String fileUrl = "/Users/jeong-yeong-gil/Desktop/SpringSecurity-Oauth2.0-jwt/src/main/resources/static/img/";

			String sourceFileName = files.getOriginalFilename();
			String sourceFileNameExtension = FilenameUtils.getExtension(sourceFileName).toLowerCase();
			File destinationFile;
			String destinationFileName;
			do { 
	            destinationFileName = RandomStringUtils.randomAlphanumeric(32) + "." + sourceFileNameExtension; 
	            destinationFile = new File(fileUrl + destinationFileName); 
	        } while (destinationFile.exists()); 
			
			destinationFile.getParentFile().mkdirs(); 
	        files.transferTo(destinationFile);
	        
			postService.PostData_Insert(post);
			FileInfo file = new FileInfo(post.getPost_id(), sourceFileName, destinationFileName, fileUrl);
			
			postService.PostFile_Insert(file);

		}
		else {
			postService.PostData_Insert(post);
		}
		return "redirect:/post/list";
	}

	@GetMapping("/post/single/{post_id}")
	public String post(@PathVariable int post_id, Model model) {
		model.addAttribute("post", postService.post(post_id));
		model.addAttribute("file", postService.postfile(post_id));
		return "post";
	}
	
	@GetMapping("/fileDown/{post_id}")
    private void fileDown(@PathVariable int post_id, HttpServletRequest request, HttpServletResponse response) throws Exception{
        
        request.setCharacterEncoding("UTF-8");
        FileInfo filedata = postService.postfile(post_id);
        System.out.println(filedata);
        //파일 업로드된 경로 
        try{
            String fileUrl = filedata.getFileUrl();
            String savePath = fileUrl;
            String fileName = filedata.getFileName();
            
            //실제 내보낼 파일명 
            String oriFileName = filedata.getFileOriginalName();
            InputStream in = null;
            OutputStream os = null;
            File file = null;
            boolean skip = false;
            String client = "";
            
            //파일을 읽어 스트림에 담기  
            try{
                file = new File(savePath, oriFileName);
                in = new FileInputStream(file);
            } catch (FileNotFoundException fe) {
                skip = true;
            }
            
            client = request.getHeader("User-Agent");
            
            System.out.println(client);
            //파일 다운로드 헤더 지정 
            response.reset();
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Description", "JSP Generated Data");
            
            if (!skip) {
                // IE
                if (client.indexOf("MSIE") != -1) {
                    response.setHeader("Content-Disposition", "attachment; filename=\""
                            + java.net.URLEncoder.encode(oriFileName, "UTF-8").replaceAll("\\+", "\\ ") + "\"");
                    // IE 11 이상.
                } else if (client.indexOf("Trident") != -1) {
                    response.setHeader("Content-Disposition", "attachment; filename=\""
                            + java.net.URLEncoder.encode(oriFileName, "UTF-8").replaceAll("\\+", "\\ ") + "\"");
                } else {
                    // 한글 파일명 처리
                    response.setHeader("Content-Disposition",
                            "attachment; filename=\"" + new String(oriFileName.getBytes("UTF-8"), "ISO8859_1") + "\"");
                    response.setHeader("Content-Type", "application/octet-stream; charset=utf-8");
                }
                response.setHeader("Content-Length", "" + file.length());
                os = response.getOutputStream();
                byte b[] = new byte[(int) file.length()];
                int leng = 0;
                while ((leng = in.read(b)) > 0) {
                    os.write(b, 0, leng);
                }
            } else {
                response.setContentType("text/html;charset=UTF-8");
                System.out.println("<script language='javascript'>alert('파일을 찾을 수 없습니다');history.back();</script>");
            }
            in.close();
            os.close();
        } catch (Exception e) {
            System.out.println("ERROR : " + e.getMessage());
        }
        
    }

}