package com.security_blog.yg1110.servicer;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


@Service
public class EmailService {
	
    private JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendMail(String toEmail, String subject, String message) throws MessagingException {
    	MimeMessage mimeMessage = javaMailSender.createMimeMessage();
    	MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
    	
    	helper.setFrom("YG1110BLOG"); //보내는사람
    	helper.setTo(toEmail); //받는사람
    	helper.setSubject(subject); //메일제목
    	helper.setText(message, true); //ture넣을경우 html


        javaMailSender.send(mimeMessage);
    }
}