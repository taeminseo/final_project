package com.spring.project.food.member;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.project.food.member.MailService;

@Controller
public class MailController {
	@Autowired(required = false) private MailService mailService;
	@Autowired(required = false) private HttpSession session;
	@Autowired(required = false) JavaMailSender mailSender;
	
	@ResponseBody
	@PostMapping(value="sendAuth",produces="application/json; charset=UTF-8")
	public String sendAuth(@RequestBody(required = false)String email) {
		if(email != null) {
			Random r = new Random();
			String number =String.format("%06d", r.nextInt(1000000));
			System.out.println("인증번호 :" + number);
			mailService.sendMail(email,"[인증번호]",number);
			session.setAttribute("authNumber", number);
			return "인증 번호 전송";
		}else {
			return "이메일을 입력하세요";
		}
		
	}
	
	@ResponseBody
	@PostMapping(value="checkAuth",produces="application/json; charset=UTF-8")
	public String checkAuth(@RequestBody(required = false)Map<String,String> map) {
		System.out.println("고객이 입력한 인증번호:" + map.get("authNumber"));
		
		String sessionAuthNumber = (String)session.getAttribute("authNumber");
		String clientAuthNumber = map.get("authNumber");
		if(sessionAuthNumber == null) {
			return "인증 번호를 생성하세요";
		}
		if(clientAuthNumber.isEmpty()) {
			return "인증 번호를 입력하세요";
		}
		
		session.setAttribute("authStatus", false);
		if(sessionAuthNumber.equals(clientAuthNumber)) {
			session.setAttribute("authStatus", true);
			return "인증 성공";
		}
		
		return "인증 실패";
	}
	
}
