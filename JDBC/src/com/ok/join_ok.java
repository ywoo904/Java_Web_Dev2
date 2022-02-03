package com.ok;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/join_ok")
public class join_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public join_ok() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 입력값 처리 
		request.setCharacterEncoding("utf-8");
		String id= request.getParameter("id");
		String pw= request.getParameter("pw");
		String name= request.getParameter("name");
		String phone1= request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String email= request.getParameter("email");
		String gender= request.getParameter("gender");
		
		//DAO객체 선언 
		MemberDAO dao = MemberDAO.getInstance();
		
		//VO객체 생성  
		MemberVO vo = new MemberVO (id, pw, name, phone1,phone2,email,gender); 
		
		//DAO에 join메서드 사용 
		int result =dao.join(vo); 
		
		
		//2.DB연동처리 
		/*
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String driver= "oracle.jdbc.driver.OracleDriver";
		String uid = "myjsp"; 
		String upw ="myjsp"; 
		
		Connection conn = null; 
		Statement stmt =null; 
		ResultSet rs = null;
	
		String sql ="INSERT INTO TESTUSERS VALUES ('"+id+"', '"+pw+"', '"+name+"','"+phone1+"','"+phone2+"','"+email+"','"+gender+"') "; 
		
		try { 
			Class.forName(driver);
			conn= DriverManager.getConnection(url,uid,upw); 
			stmt= conn.createStatement(); 
			int result= stmt.executeUpdate(sql); 
			
			*/
			if (result==1) { 
				response.sendRedirect("join_success.jsp");
			} else {  
				response.sendRedirect("join_fail.jsp"); } 
			
			/*
 		} catch (Exception e) { 
 			e.printStackTrace() ;
 			
 		}finally  { 
 			try {     
 				if (conn!=null) conn.close(); 
 				if (stmt!=null) stmt.close(); 
 				
 			} catch (Exception e ) { } 
 			
 		} 
	
		//3. 처리결과에 따른 뷰(view)  
		//성공: Success -> 성공메시지를 출력 
		//실패시: Fail -> 실패메시지 전송-> 로그인 또는 회원가입 

	}
*/
} } 
