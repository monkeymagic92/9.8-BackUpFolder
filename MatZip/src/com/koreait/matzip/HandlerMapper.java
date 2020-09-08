package com.koreait.matzip;

import javax.servlet.http.HttpServletRequest;

import com.koreait.matzip.user.UserController;

public class HandlerMapper {
	private UserController userCon;
	
	public HandlerMapper() {
		userCon = new UserController();
	}
	
	
	public String nav(HttpServletRequest request) {
		String[]  uriArr = request.getRequestURI().split("/");
		
		
		// 앞주소 (컨트롤러구분) 2번째부분(호출할 메소드구분) 이기에
		// 항상 uriArr.length 는 2이상이 나올수뿐이 없으니 < 3 로해준것
		if(uriArr.length < 3) {
			return "405";
		}
		
		
		// 1번방 = user ? board? 레스토랑 ? 등등 컨트롤러
		// 2번방 = user에 관한 login 이든 insert이든 등등..
		switch(uriArr[1]) {
		case ViewRef.URI_USER:
			
			switch(uriArr[2]) {
			case "login":
				return userCon.login(request);
				
			case "join":
				return userCon.join(request);
				
			case "joinProc":
				return userCon.joinProc(request);
			}			
		}
		
		return "404"; // 위에 내용중 해당되는, 아무것도 넘어오는 값이 없다면  404 not found 
		
	}
}
