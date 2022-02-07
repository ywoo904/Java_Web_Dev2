package com.myweb.user.model;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.myweb.util.JdbcUtil;



public class UserDAO { 
		private DataSource ds;  
		private Context ct;  
	
	/*
	 * DAO는 단순 DB연동을 담당하는 클래스 
	 * 여러개 생성하도록 일반 클래스로 만들면 메모리 과부하가 올 수 있다. 
	 * 싱글톤 패턴을 적용해서 객체를 1개로 제한. */
	 
	// 1. 스스로의 객체를 맴버변수로 선언하고 1개로 제한  
	private static UserDAO instance= new UserDAO();
	
	//2. 외부에서 객체를 생성할 수 없도록 생성자에 private를 처리  
	private UserDAO()  {
		try { 
			ct= new InitialContext();  //context.xml을 삽입하는 역할 
			ds= (DataSource)ct.lookup("java:comp/env/jdbc/oracle"); //DataSource 타입으로 형변환
				} catch (Exception e  ) { 
			System.out.println("Conntextion Pool 에러발생");
		} 	
	}
	
	//3. 외부에서 객체를 요구할 때 getter 메서드를 사용하여 반환. 
	public static UserDAO getInstance() { 
		return instance;
	} 
	
	//---------------------- 중복되는 코드를 멤버변수로 선언-----------------------------
	//DB연동에 필요한 변수를 선언 

	private Connection conn = null; 
	private PreparedStatement pstmt = null; 
	private ResultSet rs= null; 

	//ID확인메서드 
	public int IdConfirm(String id)  { 
		int result = 0; 
		String sql = "SELECT * FROM users WHERE ID=?"; 
		try { 
			conn= ds.getConnection();
		
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1,id);
			rs= pstmt.executeQuery();
			if (rs.next()) {
				result= 1; 
			} else  { 
				result=0; 
			}
		} catch (Exception e  ) {
			e.printStackTrace();
		} finally  { 
			try { 
				JdbcUtil.close(conn, pstmt, rs); 
			} catch (Exception e2) { } 
		}
		return result;  
	} 
	
	
	//회원가입메서드
	public int join(UserVO vo ) {
		int result = 0; 
		String sql = "INSERT into users (ID, PW, NAME, EMAIL, ADDRESS)"
				+ "values (?,?,?,?,?)";
		
		try {
			//Connection 객체생성 
			conn= ds.getConnection();

			
			//PreparedStatement 객체생성 
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getAddress());
			
			//SQL 실행 
			result= pstmt.executeUpdate( );
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally { 
			try {
				JdbcUtil.close(conn, pstmt, rs); 
				
			} catch (Exception e2) {
			} 
		}  
		return result; 
		}
	
	//로그인메서드 
	public int login(String id, String pw) {
		int result = 0; 
		String sql = "SELECT * FROM users where ID=? and PW=?";
		try {
			//Connection 객체생성 
			conn= ds.getConnection();
			//PreparedStatement 객체생성 
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs =pstmt.executeQuery();
			//SQL 실행 
			if (rs.next()) result=1; 
			else  { result=0; } 
			
		} catch (Exception e) {
			e.printStackTrace(); //에러발생 시 그냥 보여주세요 
		} finally { 
			try {
				JdbcUtil.close(conn, pstmt, rs); //JDBC클래스의  close 메소드 
				
					} catch (Exception e2) {
			} 
		}  
		return result; 
		}
	
	//고객정보조회 메서드 
	public UserVO getUserInfo(String id1) {
		UserVO vo = null;
		String sql= "SELECT * FROM users where ID=?"; 
		try { 
			conn=ds.getConnection();  
			pstmt= conn.prepareStatement(sql); 
			pstmt.setString(1, id1);
			rs= pstmt.executeQuery(); 
			
			while(rs.next()) { 
				//DB에서 getString(컬럼명), getTimeStamp(컬럼명) 메서드를 이용
				//rs의 데이터를 vo에 저장
				String id= rs.getString("id");
				String name = rs.getString("name"); 
				String email= rs.getString("email"); 
				String address = rs.getString("address"); 
				Timestamp regdate = rs.getTimestamp("regdate");
				
				vo = new UserVO(id, null,  name, email, address, regdate);
			
		}} catch (Exception e) { 
			e.printStackTrace(); 
		} finally  { 
			JdbcUtil.close(conn, pstmt, rs); 
		}
		return vo; 
	} 
	
	//비밀번호 변경메서드  
	public int changepassword(String id2, String new_pw) { 
		int result1= 0;
		
		String sql= "UPDATE USERS SET PW=? WHERE ID=?"; 
		try {  
			conn=ds.getConnection(); 
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, new_pw ); 
			pstmt.setString(2, id2);
			result1= pstmt.executeUpdate( );
			} catch (Exception e) {
			e.printStackTrace();
		} finally { 
			try {
				JdbcUtil.close(conn, pstmt, rs); 
				
			} catch (Exception e2) {
			} 
		}  
		return result1; 
		}
		
		
	
	
	
	
	
	
	
}









