package com.myweb.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {

	
	
	//1. 스스로 객체를 멤버변수로 선언하고 1개 제한- 싱글톤
	private static BoardDAO instance= new  BoardDAO(); 
	
	 
	
	//2. 외부에서 객체를 생성할 수 없도록 생성자에 private처리  
	private BoardDAO() {
		try { 
			//Context.xml값에 저장된 설정을 저장하기 위해서 
			InitialContext ctx = new InitialContext(); 
			ds =  (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");   
		} catch  (Exception e) {
			System.out.println("커넥션 풀링 에러발생");
			
		} 
	} 
	
	//3. 외부에서 객체를 요구할 떄 getter메서드만 써서 반환 
	public static BoardDAO getInstance() { 
		return instance; 	
	}

	//---------------------------중복되는 코드 멤버변수 선언--------------------------
	private DataSource ds; 
	
	private Connection conn = null; 
	private PreparedStatement pstmt = null; 
	private ResultSet rs= null; 
	
	
	
	
	
	
	
	
	
	
	
}
