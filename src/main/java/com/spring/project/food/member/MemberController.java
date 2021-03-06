package com.spring.project.food.member;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.scribejava.core.model.OAuth2AccessToken;
import com.spring.project.food.order.IOrderService;
import com.spring.project.food.order.OrderDAO;
import com.spring.project.food.order.OrderDTO;
import com.spring.project.food.order.OrderService;
import com.spring.project.food.shop.menu.MenuDTO;

@Controller
public class MemberController {
	@Autowired MemberService memberService;
	@Autowired OrderService orderService;
	@Autowired(required = false) JavaMailSender mailSender;
	
	@PostMapping(value = "isExistId", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String isExistId(@RequestBody(required = false) String member_id) {
		String msg = memberService.isExistId(member_id);
		return msg;
	}
	
	@RequestMapping(value = "memberProc")
	public String memberProc(MemberDTO member, Model model, RedirectAttributes ra) {
		String msg = memberService.memberProc(member);
		
		
		
		if(msg.equals("????????????")) {
			ra.addFlashAttribute("msg", msg);
			return "home";
		}else {
			model.addAttribute("msg", msg);
			return "forward:member";
		}
	}
	
	@RequestMapping(value = "loginProc")
	public String loginPorc(LoginDTO member, Model model) {
		String msg = memberService.loginProc(member);
		if(msg.equals("????????? ??????")) {
			return "redirect:/home";
		}
			model.addAttribute("msg", msg);
			return "forward:/login";
		}
	
	@RequestMapping(value = "logout")
	public String logout(Model model, HttpSession session) {
		session.invalidate();
		
		return "forward:/home";
	}
	
    /* NaverLoginBO */
    private NaverLoginBO naverLoginBO;
    private String apiResult = null;
    
    @Autowired
    private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
        this.naverLoginBO = naverLoginBO;
    }
 
    //????????? ??? ?????? ?????? ?????????
    @RequestMapping(value = "login", method = { RequestMethod.GET, RequestMethod.POST })
    public String login(Model model, HttpSession session) {
        
        /* ????????????????????? ?????? URL??? ???????????? ????????? naverLoginBO???????????? getAuthorizationUrl????????? ?????? */
        String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
        
        System.out.println("?????????:" + naverAuthUrl);
        
        //????????? 
        model.addAttribute("url", naverAuthUrl);
 
        /* ????????? ?????? URL??? View??? ?????? */
        return "member/member_login";
    }
 
    //????????? ????????? ????????? callback?????? ?????????
    @RequestMapping(value = "/callback", method = { RequestMethod.GET, RequestMethod.POST })
    public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session)
            throws IOException {
        System.out.println("????????? callback");
        OAuth2AccessToken oauthToken;
        oauthToken = naverLoginBO.getAccessToken(session, code, state);
        //????????? ????????? ????????? ????????????.
        apiResult = naverLoginBO.getUserProfile(oauthToken);
        model.addAttribute("result", apiResult);
 
        /* ????????? ????????? ?????? ????????? View ?????? */
        return "naverSuccess";
    }

	
	@RequestMapping(value = "/orderHistory")
	public String orderHistory(Model model, HttpSession session) {
		String member_id = (String) session.getAttribute("id");
		System.out.println(member_id);
		ArrayList<OrderDTO> hiList = orderService.hiList(member_id);
		
		model.addAttribute("hiList", hiList);
		return "member/orderHistory";
	}
	

	@RequestMapping(value = "/findid")
	public String findid() {
		return "/member/findid";
	}
	

	
	@RequestMapping(value = "findpw")
	public String findpw() {
		return "member/findpw";
	}
	
	
	@GetMapping(value = "/findpw")//????????? ?????? ?????? //???????????? ???????????? ??????
	public ModelAndView findPwGet(ModelAndView mv) {
		mv.setViewName("/member/findpw");
		return mv;
	}
	@ResponseBody
	@GetMapping(value = "/findpw/{member_id}")//????????? ?????? ?????? //???????????? ???????????? ??????
	public String findPwGet(@PathVariable("member_id") String member_id) {
		System.out.println(member_id);
		MemberDTO member = memberService.getMember(member_id);
		if(member == null)
			return "FAIL";

		 try {
		        MimeMessage message = mailSender.createMimeMessage();
		        MimeMessageHelper messageHelper 
		            = new MimeMessageHelper(message, true, "UTF-8");
		        //?????? ???????????? ??????
		        String newPw = newPw();
		        //??? ??????????????? ????????? ??????
		        member.setPw(newPw);
		        memberService.updateMember(member);

		        messageHelper.setFrom("abc@naver.com");  // ??????????????? ??????????????? ?????? ??????????????? ??????
		        messageHelper.setTo(member.getEmail());     // ???????????? ?????????
		        messageHelper.setSubject("??? ??????????????? ???????????????."); // ??????????????? ????????? ????????????
		        messageHelper.setText("","????????? ??? ??????????????? <b>" + newPw + "</b>?????????.");  // ?????? ??????

		        mailSender.send(message);
		        return "SUCCESS";
		        //System.out.println(message);
		    } catch(Exception e){
		        System.out.println(e);
		    }
			return "FAIL";
	}
	//8????????? ?????? or ?????? ??????????????? ??? ????????????
	private String newPw() {
		// ???????????? : 0~9 => ????????? : 0~9
		// ???????????? : 10~35 => ????????? a~z
		// ???????????? : 36~61 => ????????? : A~Z 
		//12 => c
		String pw="";
		int max = 61, min = 0;
		for(int i=0; i<8; i++) {
			int r = (int)(Math.random()*(max-min+1)) + min;
			//int r = (int)(Math.random()*62);
			if(r<=9) {
				pw += r;
			}else if( r<=35) {
				pw += (char)('a'+(r-10));
			}else {
				pw += (char)('A'+(r-36));
			}
		}
		return pw;
	}
	@GetMapping(value = "/findid")//????????? ?????? ?????? //???????????? ???????????? ??????
	public ModelAndView findIdGet(ModelAndView mv) {
		mv.setViewName("/member/findid");
		return mv;
	}
	@ResponseBody
	@PostMapping(value = "/findid")
	public String findIdPost(String email) {
		System.out.println(email);
		ArrayList<MemberDTO> userList = memberService.getMemberByEmail(email);
		if(userList == null || userList.size() == 0)
			return "FAIL";
		 try {
			 	ArrayList<String> idList = new ArrayList<String>();
			 	for(MemberDTO member : userList) {
			 		idList.add(member.getMember_id());
			 	}
		        MimeMessage message = mailSender.createMimeMessage();
		        MimeMessageHelper messageHelper 
		            = new MimeMessageHelper(message, true, "UTF-8");

		        messageHelper.setFrom("abc@naver.com");  // ??????????????? ??????????????? ?????? ??????????????? ??????
		        messageHelper.setTo(email);     // ???????????? ?????????
		        messageHelper.setSubject("????????? ???????????? ??????????????????."); // ??????????????? ????????? ????????????
		        messageHelper.setText("","????????? ???????????? <b>" + idList.toString().replaceAll("[\\[\\]]","") + "</b>?????????.");  // ?????? ?????? |  ????????? ???????????? ?????????

		        System.out.println(idList + "" + message);
		        mailSender.send(message);
		        return "SUCCESS";
		    } catch(Exception e){
		        System.out.println(e);
		    }
			return "FAIL";
	}
	
	@RequestMapping("/kakaoLogin")
	public String kakaoLogin(String code,HttpSession session) {
		System.out.println("????????? ?????? ?????? : " + code);
		String accessToken = memberService.getAccessToken(code);
		HashMap<String, Object> userInfo = memberService.getUserInfo(accessToken);
		
		System.out.println("????????? ????????? ???????????? ????????? : " + userInfo.get("nickname"));
		
		session.setAttribute("id", userInfo.get("nickname"));
		session.setAttribute("accessToken", accessToken);
		return "home";
	}
	
	
	
	

}
