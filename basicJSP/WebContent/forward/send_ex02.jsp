<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	request.setAttribute("id", id);
	request.setAttribute("pw", pw);
	
	request.getRequestDispatcher("send_ex03.jsp").include(request, response);
	
	//response.sendRedirect("send_ex03.jsp");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>