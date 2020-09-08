package com.koreait.matzip.user;

import javax.servlet.http.HttpServletRequest;

import com.koreait.matzip.Const;
import com.koreait.matzip.ViewRef;



// 기존에 만들었던 서블릿의 역활을 UserController 가 한다 
/*
 * 		login 메소드는 화면열때 필수 메소드 
 */
public class UserController {

	// login.jsp 로 넘어가는 창
	//		/user/login     인덱스0번 = 빈칸 ,   1번 = user , 2번 = login
	public String login(HttpServletRequest request) {
		
		request.setAttribute(Const.TITLE, "로그인");
		request.setAttribute(Const.VIEW, "user/login");  // include 할 부분
		return ViewRef.TEMP_DEFAULT;  // 어떤 주소로 갈건지 ? DEFAULT or TYPE_1
	}
	
	
	// join.jsp 로 넘어가는 창
	// 		/user/join 
	public String join(HttpServletRequest request) {
		request.setAttribute(Const.TITLE,"회원가입");
		request.setAttribute(Const.VIEW, "user/join");
		return ViewRef.TEMP_DEFAULT;
	}
	
	

	public String joinProc(HttpServletRequest request) {
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String nm = request.getParameter("nm");		
		
		return "redirect:/user/login";
	}
	
}
