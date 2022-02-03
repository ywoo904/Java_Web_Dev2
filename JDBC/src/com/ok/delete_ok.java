package com.ok;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//delete_ok (session)
//redirect <- 
//success <- login / fail <- mypage 
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

@WebServlet("/delete_ok")
public class delete_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public delete_ok() {
        super();
  
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 /*
		  * Delete from 테이블명 where id = ? 
		  * 1. 아이디는 세션에서 get
		  * 2. pstmet 이용해서 삭제를 진행 
		  * 3. 사용 메섣느느 executeUpdate() 로 sql 문을 진행 
		  * 1을 반환 => 세션삭제 후 login,jsp로 이동 
		  * 0을 반환 => 쿼리 실패, mypage.jsp로 이동 
		  * */
		HttpSession session = request.getSession(); //세션객체생성
		String id= (String)session.getAttribute("user_id");  
		
		//DB 연동
		String url= "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String uid= "myjsp"; 
		String upw=  "myjsp"; 
		String driver= "oracle.jdbc.driver.OracleDriver"; 
		
		Connection conn = null; 
		PreparedStatement pstmt= null; 
		String sql = "DELETE From testusers where ID=?"; 
		
		try { 
			Class.forName(driver); 
			conn= DriverManager.getConnection(url, uid,upw); 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id); 
		
			
			int result= pstmt.executeUpdate(); 
			
			if (result==1) { 
				 session.invalidate(); 
				response.sendRedirect("login.jsp"); 
	
			} else {  
				response.sendRedirect("mypage.jsp"); 
			}
		} catch(Exception e  )  {
			e.printStackTrace();
			
		}  finally { 
			
		} try { 
			if (conn!=null) conn.close(); 
			if(pstmt!=null ) pstmt.close() ; 
			
		} catch (Exception e2) { } 
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}

}
