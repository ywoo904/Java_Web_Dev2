<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>if절 확인</h2>
	<form action="jstl_if.jsp">  
	이름: <input type="text" name="name">  <br> 
	나이: <input type= "text" name= "age" > <br> 
	<input type="submit" value="확인" > 	
	</form>

	<hr>  
	<h2>else if절 확인</h2>
	<form action= "jstl_choose.jsp"> 
	이름: <input type="text" name="name">  <br> 
	나이: <input type= "text" name= "age" > <br> 
	<input type="submit" value="확인" > 	
	</form>
	
	<hr> 
	<h2>else if절 확인2</h2>
	<form action= "jstl_choose2.jsp">  
	점수: <input type= "text" name= "point" > <br> 
	<input type="submit" value="확인" > 	
	</form>
		


</body>
</html>