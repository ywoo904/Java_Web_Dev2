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
		
		HttpSession session = request.getSession(); //세션객체생성
		String id= (String)session.getAttribute("user_id");  
		/*
		 * 1. 아이디는 세션에서 얻는다. 
			2. DAO에 delete (id) 생성
			3. 메서드 생성시에 executeUpdate() 메서드를 사용하여 성공시 delete(id) 메서드에서 
			1을 반환-> 세션을 전부 삭제 후 login,jsp로 이동
			0을 반환 -> mypage.jsp로 이동 
		 * */
		//DAO 객체를 불러온다.
		MemberDAO dao = MemberDAO.getInstance(); 
		//VO객체를 불러올 필요가 없다. 바로 DAO클래스 돌린 값을 불러오기
		int result = dao.delete(id);
		
		if (result==1) {  
			session.invalidate();
			response.sendRedirect("login.jsp");
		} else { 
			response.sendRedirect("mypage.jsp");
		} 
		
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}

}
