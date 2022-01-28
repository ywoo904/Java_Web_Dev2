package com.ok;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/join_ok_prepare")
public class join_ok_prepare extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public join_ok_prepare() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id= request.getParameter("id"); 
		String pw= request.getParameter("pw"); 
		String name= request.getParameter("name"); 
		String phone1 = request.getParameter("phone1"); 
		String phone2= request.getParameter("phone2"); 
		String email= request.getParameter("email"); 
		String gender= request.getParameter("gender"); 
		
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String driver= "oracle.jdbc.driver.OracleDriver"; 
		String uid= "myjsp";
		String upw="myjsp"; 
		
		Connection conn = null; 
		PreparedStatement  pstmt = null;  
		
		String sql = "INSERT INTO TESTUSERS VALUES (?,?,?,?,?,?,?)"; 
		
		try { 
			Class.forName(driver); 
			conn= DriverManager.getConnection(url,uid,upw); 
			pstmt = conn.prepareStatement(sql); 
			
			pstmt.setString(1, id); 
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, phone1);
			pstmt.setString(5, phone2);
			pstmt.setString(6, email);
			pstmt.setString(7, gender);
			
			int result= pstmt.executeUpdate(); 
			
			if (result==1) { 
				System.out.println("입력성공");
			} else  {
				System.out.println("입력실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace(); ;
		} finally  { 
			try {  
				if(conn!=null) conn.close();
				if(pstmt!=null) pstmt.close();
				
			} catch (Exception e)  { } 
			
		} 
		
		
		
		
		
	}
	
	
	
	
	

}
