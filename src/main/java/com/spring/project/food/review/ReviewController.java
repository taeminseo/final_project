package com.spring.project.food.review;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.spring.project.food.member.MemberDTO;
import com.spring.project.food.member.MemberService;
import com.spring.project.food.order.OrderDTO;
import com.spring.project.food.order.OrderService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ReviewController {
	@Autowired OrderService orderService;
	@Autowired ReviewService reviewService;
	@Autowired MemberService memberService;
	private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@RequestMapping(value = "/review")
	public String sReview(Model model,String shop_id, String shop_name) {
		ArrayList<ReviewDTO> sReview = reviewService.sReview(shop_id);
	//	ArrayList<MemberDTO> member = memberService.selectId();
		model.addAttribute("shop_name", shop_name);
		model.addAttribute("shop_id", shop_id);
		if(sReview != null)
			model.addAttribute("sReview", sReview);
		return "order/review";
	}
	
	@RequestMapping(value = "/reviewRegister")
	public String reviewRegister(OrderDTO order, Model model) {

	System.out.println(order);	
		
	model.addAttribute("orderRe", order);
	
	
		return "member/review_register";
	}
	
	@RequestMapping(value="/reviewSend")
	public String reviewRegis(ReviewDTO reviewDto, HttpSession session) {
		System.out.println(reviewDto);
		
		//??????????????? ????????????
		if(session.getAttribute("savedFileName") != null) {
			String fileName = (String) session.getAttribute("savedFileName");
			reviewDto.setUpload_filename(fileName);
			System.out.println("?????? ?????? ??????"+reviewDto.getUpload_filename());
		}else {
			reviewDto.setUpload_filename("1");
		}
		
		int count = reviewService.reviewRegister(reviewDto);
		int reviewCheck = reviewService.reviewCheckUp(reviewDto);
		
		session.removeAttribute("savedFileName");
		
		return "redirect:/orderHistory";
	}
	
	
	//??????????????? ????????? ????????? ????????????
	@ResponseBody
	@RequestMapping(value = "/file-upload", method = RequestMethod.POST)
	public String fileUpload(
			@RequestParam("article_file") List<MultipartFile> multipartFile
			, HttpServletRequest request, HttpSession session) {
		
		String strResult = "{ \"result\":\"FAIL\" }";
		String contextRoot = new HttpServletRequestWrapper(request).getRealPath("/");
		String fileRoot;
		try {
			// ????????? ????????? ??????.
			if(multipartFile.size() > 0 && !multipartFile.get(0).getOriginalFilename().equals("")) {
				
				for(MultipartFile file:multipartFile) {
					fileRoot = "C:/JAVAS/spring_workspace/final_project/src/main/webapp/resources/upLoadImg/";
			
					System.out.println("?????? " +fileRoot);
					
					String originalFileName = file.getOriginalFilename();	//???????????? ?????????
					String extension = originalFileName.substring(originalFileName.lastIndexOf("."));	//?????? ?????????
					String savedFileName = UUID.randomUUID() + extension;	//????????? ?????? ???
					
					File targetFile = new File(fileRoot + savedFileName);	
					try {
						InputStream fileStream = file.getInputStream();
						FileUtils.copyInputStreamToFile(fileStream, targetFile); //?????? ??????
						session.setAttribute("savedFileName", savedFileName);
						System.out.println(savedFileName);
					} catch (Exception e) {
						//????????????
						FileUtils.deleteQuietly(targetFile);	//????????? ?????? ?????? ??????
						e.printStackTrace();
						break;
					}
				}
				strResult = "{ \"result\":\"OK\" }";
			}
			// ?????? ???????????? ?????? ???????????? ??????.(???????????????, ????????? ?????? ?????? ??????????????????)
			else
				strResult = "{ \"result\":\"OK\" }";
		}catch(Exception e){
			e.printStackTrace();
		}
		return strResult;
	}
	
}
