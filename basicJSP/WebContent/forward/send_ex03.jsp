<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	String id = (String)request.getAttribute("id");
	String pw = (String)request.getAttribute("pw");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	입력한 id : <%=id %><br>
	입력한 pw : <%=pw %><br>

</body>
</html>