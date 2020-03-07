package com.security_blog.yg1110.controller;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.security_blog.yg1110.domain.User;
import com.security_blog.yg1110.servicer.EmailService;
import com.security_blog.yg1110.servicer.IUserService;

@RestController
public class EmailController {

	@Autowired
	private EmailService emailService;
	
	@Autowired
	private IUserService userservice;

	@GetMapping(value = "/user/email/send")
	public void sendmail(User user) throws MessagingException {
		System.out.println(user);
		StringBuffer emailcontent = new StringBuffer();
		emailcontent.append("<!DOCTYPE html>");
		emailcontent.append("<html>");
		emailcontent.append("<head>");
		emailcontent.append("</head>");
		emailcontent.append("<body>");
		emailcontent.append(
				" <div" 																																																	+ 
				"	style=\"font-family: 'Apple SD Gothic Neo', 'sans-serif' !important; width: 400px; height: 600px; border-top: 4px solid #02b875; margin: 100px auto; padding: 30px 0; box-sizing: border-box;\">"		+ 
				"	<h1 style=\"margin: 0; padding: 0 5px; font-size: 28px; font-weight: 400;\">"																															+ 
				"		<span style=\"font-size: 15px; margin: 0 0 10px 3px;\">YG1110 BLOG</span><br />"																													+ 
				"		<span style=\"color: #02b875\">메일인증</span> 안내입니다."																																				+ 
				"	</h1>\n"																																																+ 
				"	<p style=\"font-size: 16px; line-height: 26px; margin-top: 50px; padding: 0 5px;\">"																													+ 
				user.getName()																																																+
				"		님 안녕하세요.<br />"																																													+ 
				"		YG1110 BLOG에 가입해 주셔서 진심으로 감사드립니다.<br />"																																						+ 
				"		아래 <b style=\"color: #02b875\">'메일 인증'</b> 버튼을 클릭하여 회원가입을 완료해 주세요.<br />"																													+ 
				"		감사합니다."																																															+ 
				"	</p>"																																																	+ 
				"	<a style=\"color: #FFF; text-decoration: none; text-align: center;\""																																	+
				"	href=\"http://localhost:8080/user/email/certified?username=" + user.getUsername() + "&certified=" + user.getCertified() + "\" target=\"_blank\">"															+ 
				"		<p"																																																	+
				"			style=\"display: inline-block; width: 210px; height: 45px; margin: 30px 5px 40px; background: #02b875; line-height: 45px; vertical-align: middle; font-size: 16px;\">"							+ 
				"			메일 인증</p>"																																														+ 
				"	</a>"																																																	+
				"	<div style=\"border-top: 1px solid #DDD; padding: 5px;\"></div>"																																		+
				" </div>"
		);
		emailcontent.append("</body>");
		emailcontent.append("</html>");
		emailService.sendMail("younggil9488@gmail.com", "[YG1110 이메일 인증]", emailcontent.toString());
	}
	
	@GetMapping(value = "/user/email/certified")
	@Transactional
	public ModelAndView checkmail(HttpServletRequest request, User user) throws MessagingException {
		HttpSession session = request.getSession();
		User u = userservice.email_certified_check(user);
		
		if(u != null) {
			userservice.email_certified_update(user);
			SecurityContextHolder.getContext().setAuthentication(null);
			session.removeAttribute("Authorization");
		}

		return new ModelAndView("email_success");
	}
}
