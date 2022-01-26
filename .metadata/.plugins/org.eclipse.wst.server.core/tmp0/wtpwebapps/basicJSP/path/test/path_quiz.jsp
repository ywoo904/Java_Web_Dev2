<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- a 태그를 이용하여 경로를 이동 -->
	<!-- reg_video페이지로 상대경로로 이동설정 -->
	<a href="../../request/req_video.jsp">상대경로(req_video.jsp)</a><br>
	<!-- reg_video페이지로 절대경로로 이동설정 -->
	<a href="/basicJSP/request/req_video.jsp">절대경로(req_video.jsp)</a><br>
	<!-- TestServlet으로 상대경로로 이동설정 -->
	<a href="../../apple">서블릿 상대 경로(TestServlet)</a><br>
	<!-- TestServlet으로 절대경로로 이동설정 -->
	<a href="/basicJSP/apple">서블릿 절대 경로(TestServlet)</a><br>
	<!-- request에 img폴더에 있는 노을이미지를 참조(img태그 사용-width=100) -->
	<img src="../../request/img/test.jfif" width="100"><br>
	
</body>
</html>