<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <% 
  //인증되지 않은 사용자들을 인증시키기 위해 로그인으로 되돌리기 
  
  if (session.getAttribute("user_id")==null) 
  { response.sendRedirect("login.jsp"); 	  
  }
  
  String id =  (String) session.getAttribute ("user_id");
  String name = (String) session.getAttribute("user_name");
 
  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공</title>
</head>
<body>

	<h2>(<%=id %>)<%=name %>님 환영합니다. </h2>
	<a href= logout.jsp>로그아웃</a> <br> 
	<a href= 'modify_ok'>회원정보 수정 </a><br>
	<a href= 'delete_ok'>회원탈퇴</a>
</body>
</html>