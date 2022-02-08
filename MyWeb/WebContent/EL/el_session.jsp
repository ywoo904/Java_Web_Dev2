<%@page import="com.myweb.user.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <%						// 세션이름, 세션값
  //session1) 
  session.setAttribute("id","kkk123"); 
  
  //session2) 
  UserVO vo = new UserVO(); 
  vo.setEmail("kkk123@test.com");  
  session.setAttribute("vo", vo); 
  
  //session3) 
  application.setAttribute("admin", "홍길동");
  %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="el_session_ok.jsp">세션값확인</a>


</body>
</html>