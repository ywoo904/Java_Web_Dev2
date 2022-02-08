<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8"); 
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- param은 request로 값을 받아오는 역할 -->
	이름:  ${param.name} <br>
	아이디:  ${param.id} <br>
	비밀번호:  ${param.pw} <br>



</body>
</html>