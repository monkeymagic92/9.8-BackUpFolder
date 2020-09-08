package com.koreait.matzip;

import org.apache.catalina.servlets.DefaultServlet;

/*
 *	web.xml에서 작성한 애노미테이션 ("/") 값에 / 를 제거하고 사용할수 있게 해주는 메소드
 *  따로 안에 내용 정의할 필요는 없음 DefaultServlet 메소드가 알아서 처리해주는 듯함 
 */
public class StaticContainer extends DefaultServlet {}
