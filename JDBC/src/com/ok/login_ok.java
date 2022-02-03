package com.ok;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;


@WebServlet("/login_ok")
public class login_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public login_ok() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 form으로 받은 정보전달 
		
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");  
		String pw = request.getParameter("pw");  
		
		//DB연동을 위한 변수 및 객체생성 
		String url= "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String uid= "myjsp"; 
		String upw=  "myjsp"; 
		String driver= "oracle.jdbc.driver.OracleDriver"; 
		
		Connection conn= null; 
		PreparedStatement pstmt= null; 
		ResultSet rs= null;
		
		String sql= "select * from testusers where id=? and pw=?"; 
		
		//DB연동
		try { 
			Class.forName (driver);  
			conn = DriverManager.getConnection(url, uid, upw); 
			//객체생성 및 sql 작업
			pstmt= conn.prepareStatement(sql); 
			pstmt.setString(1, id); 
			pstmt.setString(2, pw); 
			//쿼리실행
			rs= pstmt.executeQuery(); 
			
			if(rs.next()) { 
				//아이디, 패스워드일치하는 경우, 로그인 성공  
				//자바에서 Session활용하기 
					HttpSession session = request.getSession(); //세션객체생성
					session.setAttribute("user_id", id);  
					session.setAttribute("user_name", rs.getString("name"));
				response.sendRedirect("mypage.jsp"); 
			} else {  
				//로그인 실패- 아이디 혹은 비밀번호가 틀린 경우  
				response.sendRedirect("login_fail.jsp");
				
			}} catch (Exception e) {  
				e.printStackTrace();;
			} finally  { 
				
			} try { 
				if (conn!=null) conn.close(); 
				if(pstmt!=null ) pstmt.close() ; 
				if(rs!= null) rs.close();
				 
			} catch(Exception e) { } 
		
	} 
}

