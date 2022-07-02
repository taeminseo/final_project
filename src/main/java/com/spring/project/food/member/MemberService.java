package com.spring.project.food.member;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
public class MemberService implements IMemberService{

	@Autowired(required = false) IMemberDAO memberDao;
	@Autowired HttpSession session;
	
	@Override
	public String isExistId(String member_id) {
		if(member_id == null)
			return "아이디를 입력후 다시 시도하세요";
		int count = memberDao.isExistId(member_id);
		System.out.println(count);
		if(count == 1) {
			return "중복 아이디입니다.";
		}else {
			return "사용 가능한 아이디입니다.";
		}
	}
	
		
	


	@Override
	public String memberProc(MemberDTO member) {
		if(member.getMember_id() == null || member.getMember_id().isEmpty())
			return "아이디를 입력하세요";
		if(member.getPw() == null || member.getPw().isEmpty())
			return "비밀번호를 입력하세요";
		if(memberDao.isExistId(member.getMember_id()) > 0)
			return "중복아이디 입니다.";
		if(member.getPhone() == null || member.getPhone().isEmpty())
			return "핸드폰 번호를 넣고 인증하세요.";
		if(member.getEmail() == null || member.getEmail().isEmpty())
			return "이메일을 입력하세요";
		memberDao.insertMember(member);
		return "가입완료";
			
	}


	@Override
	public String loginProc(LoginDTO login) {
		if(login.getMember_id().isEmpty() || login.getPw().isEmpty())
			return "아이디/비밀번호를 입력하세요";
		
		LoginDTO check = memberDao.loginProc(login);
		
		if(check == null)
			return "아이디를 확인하세요";
		
		if(check == null || login.getPw().equals(check.getPw())) {
			session.setAttribute("id", check.getMember_id());
			session.setAttribute("member_num", check.getMember_num());
			session.setAttribute("zipcode", check.getZipcode());
			session.setAttribute("address", check.getAddress());
			session.setAttribute("address2", check.getAddress2());
			System.out.println(session.getAttribute("member_num"));
			return "로그인 성공";
		}else
			return "로그인 실패";
	}
	//https://developers.kakao.com/docs/latest/ko/kakaologin/rest-api#refresh-token
			public String getAccessToken (String code) {
				String accessToken = "";
				String reqURL = "https://kauth.kakao.com/oauth/token";
				try {
					String sendMessage = "grant_type=authorization_code" 
							+ "&client_id=0a0fe4745d35741aff2b1845c224700a"
							+"&redirect_uri=http://localhost:8085/kakaoLogin" 
							+ "&code=" + code;
				
					URL url = new URL(reqURL); // POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
					HttpURLConnection conn = (HttpURLConnection)url.openConnection();
					conn.setRequestMethod("POST"); //POST 요청을 위해 기본값 false에서 setDoOutput을 true로 변경
					conn.setDoOutput(true); // POST 메소드를 이용해서 데이터를 전달하기 위한 설정
					
					// 기본 outputStream을 통해 문자열로 처리할 수 있는 OutPutStreamWriter 변환 후 처리속도를 빠르게 하기위한
					// BufferedWriter로 변환해서 사용한다.
					BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
					bw.write(sendMessage); 
					bw.flush();
					
					int responseCode = conn.getResponseCode(); // 결과 코드가 200이라면 성공
					System.out.println("responseCode : " + responseCode);
					
					// 요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
					BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
					String line = "", result = "";
					while ((line = br.readLine()) != null) {
						result += line;
					}
	/*
	response body : 
	{
	"access_token":"bVNhfCi9cWzt9sKzgmiaT5YQvy4DZI-hChcxVQo9c5sAAAGAbc6Yzw",
	"token_type":"bearer",
	"refresh_token":"CjnYSnj_dlOtK7lfekkkRcFnlMrVHXp3bbmk9Qo9c5sAAAGAbc6YzQ",
	"expires_in":21599,
	"scope":"profile_nickname",
	"refresh_token_expires_in":5183999
	}				
	 */
					System.out.println("response body : " + result);
					System.out.println("result.split : " + result.split(","));
					
					//Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
					JsonElement element = JsonParser.parseString(result);
					accessToken = element.getAsJsonObject().get("access_token").getAsString();
					System.out.println("access_token : " + accessToken);
					
					br.close();
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				} 
				return accessToken;
			}
			
			//https://developers.kakao.com/docs/latest/ko/kakaologin/rest-api#req-user-info
			public HashMap<String, Object> getUserInfo (String accessToken) {
			    HashMap<String, Object> userInfo = new HashMap<String, Object>();
			    String reqURL = "https://kapi.kakao.com/v2/user/me";
			    
			    try {
			        URL url = new URL(reqURL);
			        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			        conn.setRequestMethod("POST");
			        
			        // 요청에 필요한 Header에 포함될 내용
			        conn.setRequestProperty("Authorization", "Bearer " + accessToken);
			        
			        
			        int responseCode = conn.getResponseCode();
			        System.out.println("responseCode : " + responseCode);
			        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			        String line = "";
			        String result = "";
			        while ((line = br.readLine()) != null) {
			            result += line;
			        }
			        System.out.println("response body : " + result);
	/*
	response body : 
	{
	"id":2220039319,
	"connected_at":"2022-04-28T01:34:58Z",
	"properties":{"nickname":"김연수"},
	"kakao_account":{"profile_nickname_needs_agreement":false,"profile":{"nickname":"김연수"}}
	}
	 */
			        JsonElement element = JsonParser.parseString(result);
//			        JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
//			        String nickname = properties.getAsJsonObject().get("nickname").getAsString();
			        
			        JsonObject kakao_account = element.getAsJsonObject().get("kakao_account").getAsJsonObject();
			        JsonObject profile = kakao_account.getAsJsonObject().get("profile").getAsJsonObject();
			        String nickname = profile.getAsJsonObject().get("nickname").getAsString();
			        
			        userInfo.put("nickname", nickname);
			        
			    } catch (IOException e) {
			        e.printStackTrace();
			    }
			    return userInfo;
			}
			
			// https://developers.kakao.com/docs/latest/ko/kakaologin/rest-api#logout
			public void logout(String accessToken) {
			    String reqURL = "https://kapi.kakao.com/v1/user/logout";
			    
			    try {
			        URL url = new URL(reqURL); // URL 객체 생성
			        HttpURLConnection conn = (HttpURLConnection) url.openConnection(); 
			        conn.setRequestMethod("POST"); // 메소드 설정
			        
			        // 요청 정보 헤더에 담기.
			        conn.setRequestProperty("Authorization", "Bearer " + accessToken);
			        // 응답 코드 확인
			        int responseCode = conn.getResponseCode();
			        System.out.println("responseCode : " + responseCode);
			    }catch (Exception e) {
					e.printStackTrace();
				}
			
	}
	
	@Override
	public MemberDTO getMember(String member_id) {
		//다오에게 아이디를 주면서 회원 정보를 가져오라고 시킴
		//가져온 회원 정보를 전달
		
		return memberDao.getMember(member_id);
	}
	@Override
	public MemberDTO updateMember(MemberDTO member) {
		//다오에게 아이디를 주면서 기존 회원 정보를 가져오라고 시킴
		if(member == null) {
			return null;
		}
		MemberDTO dbUser = memberDao.getMember(member.getMember_id());
		String member_id = member.getMember_id();
		String pw = member.getPw();
		//일치하는 회원 정보가 없으면 0을 반환
		if(dbUser == null) {
			return null;
		}
		//기존 회원 정보 중  이메일을 수정할 회원정보의 이메일로 변경
		dbUser.setEmail(member.getEmail());
		//수정할 회원 정보에 비밀번호가 있으면 기존 회원 정보의 비밀번호를 변경
		if(member.getPw()!= null && !member.getPw().equals("")) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String securePw = encoder.encode(member.getPw());
			member.setPw(securePw);
		}
		
		//다오에게 수정할 회원정보를 주면서 변경하라고 시킴
		if(memberDao.updateMember(member_id, pw) == 0) {
			return null; 
		}return dbUser;
	}

	@Override
	public ArrayList<MemberDTO> getMemberByEmail(String email) {
		if(email == null)
			return null;
		return memberDao.getMemberByEmail(email);
	}






}
