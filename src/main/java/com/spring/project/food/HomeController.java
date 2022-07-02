package com.spring.project.food;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.project.food.member.MemberService;
import com.spring.project.food.shop.menu.MenuDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired MemberService memberService;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	// /home
		@RequestMapping(value = "home")
		public void home() {
		}
		
		// 홈페이지
		@RequestMapping(value = "/")
		public String index(Model model) {
			return "home";
		}
		// 로그인
		@RequestMapping(value = "login")
		public String login() {
			return "member/member_login";
		}
		//회원가입페이지
		@RequestMapping(value = "member")
		public String member() {
			return "member/member_register";
		}
		
		
		@RequestMapping(value = "shop_home")
		public String shop_home() {
			return "shop/shop_home";
		}
		//안쓰는 페이지
		@RequestMapping(value = "index2")
		public String index2() {
			return "index2";
		}
		
		// 안쓰는페이지
		@RequestMapping(value = "index4")
		public String index4() {
			return "index4";
		}
	
	
	//이미지 불러오기위한 페이지
	@RequestMapping("/download")
	public void download(@RequestParam("imageFileName") String imageFileName,
			                 HttpServletResponse response)throws Exception {
		
		if (imageFileName == null) {
			imageFileName = "1.png";
		
		}
		System.out.println("imageFileName : " +imageFileName);

		System.out.println("다운로드컨트롤러 호출");
		OutputStream out = response.getOutputStream();
		String uploadFolder = "C:\\final_project\\shop";
		String downFile = uploadFolder + "\\" + imageFileName;
		File file = new File(downFile);

		response.setHeader("Cache-Control", "no-cache");
		// 헤더에 파일 이름 설정
		response.addHeader("Content-disposition", "attachment; fileName=" + imageFileName);
		FileInputStream in = new FileInputStream(file);
		byte[] buffer = new byte[1024 * 8];
		// 버퍼이용해서 한번에 8KBYTE씩 브라우저로 전송
		while (true) {
			int count = in.read(buffer); // 버퍼에 읽어들인 문자개수
			if (count == -1) // 버퍼의 마지막에 도달했는지 체크
				break;
			out.write(buffer, 0, count);
		}
		in.close();
		out.close();
	}

	
}
