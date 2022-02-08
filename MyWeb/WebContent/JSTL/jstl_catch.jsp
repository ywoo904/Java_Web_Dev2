<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
자바의 예외처리 구분과 같이 동작  
	try{
		검증할 내용이 있는 영역  
	} catch (Exception e)  { 
		에러 발생 시 내용이 처리될 영역
	} 
 --%>

	<!--  JSTL을 사용하는 경우 -->
	<c:catch var="abc" >   <!-- var="abc" 파트가 Exception e와 같은 역할 -->
		<!-- 검증할 내용이 있는 영역 -->
		<% 
		Class.forName("oracle.jdbc.driver.Oracle.Driver");
		%>
	</c:catch>
		<!--  에러내용은 ${abc}로 확인 -->
	${abc} <br> 


</body>
</html>