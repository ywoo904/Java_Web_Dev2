package com.myweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//무조건 봐야할 메인페이지로 동작하도록! 
@WebServlet("*.do")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public MainController() {
        super();
   
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI(); 
		String path= request.getContextPath();
		String command =  uri.substring(path.length());// 자른다음 나머지를 command로 초기화
		System.out.println(command);
		
		if (command.equals("/member.do")) { 
			RequestDispatcher dp= request.getRequestDispatcher("member/member.jsp"); 
			dp.forward(request, response);
		} else { 
			RequestDispatcher dp= request.getRequestDispatcher("index.jsp"); 
		dp.forward(request, response);
		}
			//접근하면 해당정보에 대한 요청을 무조건 index.html로 접근 
			 /*RequestDispatcher dp= request.getRequestDispatcher("index.jsp"); 
			dp.forward(request, response);
			*/
		
			
			
			
			
	}

	
	

}
