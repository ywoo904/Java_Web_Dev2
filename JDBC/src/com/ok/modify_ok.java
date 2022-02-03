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

@WebServlet("/modify_ok")
public class modify_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public modify_ok() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//정보수정을 위한 페이지 이동 시 DB 정보를 얻기 위한 작업 
		
		//DB에서 가져올 정보는 Session에서 "아이디" 값을 얻어옴(user_id로..) 
		HttpSession session =  request.getSession(); 
		String id= (String) session.getAttribute("user_id"); 
		
		//DAO
		MemberDAO dao = MemberDAO.getInstance(); 
		
		//getInfo()의 실행결과를 vo에 받게 처리. 
		MemberVO vo= dao.getInfo(id);
		
		//vo객체를 update.jsp에게 포워드 처리.
		request.setAttribute("vo", vo);
		request.getRequestDispatcher("update.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

	}

}
