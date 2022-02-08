<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%
	String test= "문자열변수 입니다."; 
	int num = 100; 

%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--  출력태그 -->

test변수값: <c:out value="<%=test %>"></c:out> <br> <!--  출력:문자열변수입니다.  -->
test변수값2: <c:out value="<%=test %>" />  <!-- 출력: 문자열변수입니다.  -->
<hr> 
<!-- 변수선언태그 -->
<c:set var="var1" value="100" scope="page" /> 
var1변수의값: ${var1} <br> <!--출력 : 변수값 100 출력 -->
<hr> 
<!--  변수제거태그 --> 
<c:remove var="var1"  scope="page" /> 
var1변수의값: ${var1} <br> <!-- 출력:  변수값 null 출력 -->
<hr> 





</body>
</html>