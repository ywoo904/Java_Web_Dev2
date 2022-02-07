<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    //URL 주소를 통해서 강제접근 막기 
   	if (session.getAttribute("user_id")==null) { 
   		response.sendRedirect("user_login.jsp"); 	} 
    
    String id = (String)session.getAttribute("user_id"); 
    String name= (String)session.getAttribute("user_name");
    
    %>
    
<!DOCTYPE html>
<html>
<%@ include file ="../include/header.jsp" %>

<section>  
<div align="center" >	
	<h2>MyPage</h2> 
	<hr>  	
	<%=id %>와 (<%=name %>) 님의 회원정보를 관리합니다.	
	<hr> 
	  <input type= "button" value= "비밀번호 변경" class= "btn btn-default" onclick="location.href='user_change_pw.jsp'"> 
	  <input type= "button" value= "회원정보 변경" class= "btn btn-primary" onclick="location.href='user_update.jsp'"> 
	  <input type= "button" value= "회원탈퇴" class= "btn btn-info" onclick="location.href='user_delete_check.jsp'"> 
	  
	  
	  
	  
</div>
</section>



<%@ include file ="../include/footer.jsp" %>


</body>
</html>