package com.koreait.matzip;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
 * 		한 서블릿으로 다몰아넣음 
 * 		장점 : 관리하기가 편하다
 */

@WebServlet("/")
	
	// Container 클래스는 톰캣이 알아서 생성해줌 
	public class Container extends HttpServlet {
		private static final long serialVersionUID = 1L;


	private HandlerMapper mapper;
	
	
	// 위에 Container 클래스가 생성될때 실행됨 (기본생성자) 
	// 생성되면 하단에 proc 클래스에서 mapper.nav 를 사용할수있음 
	public Container() {
		mapper = new HandlerMapper();
	}
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		proc(request, response);
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		proc(request, response);
		
	}
	
	
	
	private void proc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// HandlerMapper 클래스에 정의되어있음 
		String temp = mapper.nav(request);
		
		if(temp.indexOf("/") >= 0 && "redirect:".equals(temp.substring(0, temp.indexOf("/")))) {
			
			response.sendRedirect(temp.substring(temp.indexOf("/")));
			return;
			
		}
		
		
		// HandlerMapper 클래스에서 넘어오는값이 아무것도 없다면, null이라면 
		switch(temp) {
		case "405":
			temp = "/WEB-INF/view/error.jsp";
			break;
			
		case "404":
			temp ="/WEB-INF/view/notFound.jsp";
			break;
		}
		
		request.getRequestDispatcher(temp).forward(request, response);
	}

}
