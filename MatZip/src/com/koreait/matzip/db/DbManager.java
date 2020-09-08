package com.koreait.matzip.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbManager {
	
	// DB 연결하는 코드
	// DbManager 클래스 우클릭 -> Run as -> java 어쩌고 해서 db연결완료 뜨면 됨
	
//	public static void main(String[] args) {
//		try {
//			getCon();
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
		
	
	public static Connection getCon() throws Exception {
		String url = "jdbc:mysql://localhost:3306/matzip";
		String userName = "root";
		String userPassword = "orcl";
		String className = "com.mysql.cj.jdbc.Driver";
		
		Class.forName(className);
		Connection con = DriverManager.getConnection(url,userName, userPassword);
		System.out.println("DB 연결 완료!");		
		return con;
	}
	
	
	
	public static void close(PreparedStatement ps, Connection con) {
		close(null, ps, con);
	}
	
	public static void close(ResultSet rs, PreparedStatement ps, Connection con) {
		if(rs != null) try {rs.close();} catch(Exception e) {}
		if(ps != null) try {ps.close();} catch(Exception e) {}
		if(con != null) try {con.close();} catch(Exception e) {}
	}
}
