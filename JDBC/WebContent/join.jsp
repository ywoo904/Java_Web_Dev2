<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>회원가입연습</h2>

<form action="join_ok"   method="post"> 
ID : <input type="text"  value="id"  name="id" size= "10"> <br> 
PW : <input type="password" name="pw" size="10" > <br> 
이름 : <input type="text" name="name" size="10"> <br>
전화번호 : 
<select name = "phone1"> 
		<option>010</option>
		<option>011</option>
		<option>018</option>
</select>-<input type="text" name="phone2"> <br> 
이메일: <input type="email" name="email" size="30"> <br>
성별: <input type="radio" name="gender" value="m"> 남자
<input type="radio" name="gender" value="f"> 여자 
<br>
<input type="submit" value="가입" >


</form>



</body>
</html>