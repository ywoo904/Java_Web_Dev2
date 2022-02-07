<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<!DOCTYPE html>
<html>

<%@ include file="../include/header.jsp" %> 

<section> 
<div align= "center">
<h3> 비밀번호 변경페이지 </h3> 
<hr>  
<form action = "user_change_ok.jsp" method="post" > 
	현재 비밀번호: <input type="password" name="old_pw"> <br> 
	변경할 비밀번호: <input type="password" name="new_pw"> <br> 
	<input type= "submit" value="확인" >  
	<input type="button" value= "취소" onclick="history.go(-1)">

</form>
</div>
</section>



<%@ include file="../include/footer.jsp" %>




</body>
</html>