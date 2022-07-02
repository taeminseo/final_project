package com.spring.project.food.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
//이메일 인증을 위한 설정
public class MailConfig {

	@Bean
	public JavaMailSender mailSender() {
		JavaMailSenderImpl jms = new JavaMailSenderImpl();
		// 어느 메일을 이용할건지
		jms.setHost("smtp.gmail.com");
		// 포트번호
		jms.setPort(587);
		jms.setUsername("ydh312@gmail.com");
		jms.setPassword("thdwldms1!");
		
		Properties pro = new Properties();
		pro.setProperty("mail.trasport.protocol", "smtp");
		pro.setProperty("mail.smtp.auth", "true");
		// startTLS : 암호화 이용할거니? 응
		pro.setProperty("mail.smtp.starttls.enable", "true");
		jms.setJavaMailProperties(pro);
		
		return jms;
	}
	
}
