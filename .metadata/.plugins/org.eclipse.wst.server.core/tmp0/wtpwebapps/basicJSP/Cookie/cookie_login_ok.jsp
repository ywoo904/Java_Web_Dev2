<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	/*
	 1. 아이디와 비밀번호를 받아냄.
	 2. id=abc 이고, pw=1234 라면 로그인 성공이라고 간주, (user_id,id) 값을 가지는 Cookie를 생성
	 3. 쿠키 문법 사용, 쿠키를 전송 cookie_welcome.jsp로 이동
	   (cookie_welcome.jsp파일은 로그인 성공한 "xxx님 환영합니다" 가 출력되게 하세요.)
	 4. 아이디와 비밀번호가 틀렸다면, cookie_login.jsp로 이동
	*/
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String idCheck = request.getParameter("idCheck");
	
	if (id.equals("abc") && pw.equals("1234")){
		Cookie userid = new Cookie("user_id",id);
		userid.setMaxAge(30);  //30s
		response.addCookie(userid);
		
		//idCheck에 대한 코드 추가 
		if (idCheck != null) {
			Cookie check = new Cookie("idCheck",id);
			check.setMaxAge(1800); //30분
			response.addCookie(check);
		}
		
		
		response.sendRedirect("cookie_welcome.jsp");
	}else{
		response.sendRedirect("cookie_login.jsp");		
	}
%>
