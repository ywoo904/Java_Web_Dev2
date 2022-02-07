<%@page import="com.myweb.user.model.UserVO"%>
<%@page import="com.myweb.user.model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%

/*
1. 폼 값을 받기 
2. DAO 연동을 통해서 update 매서드를 호출 회원정보를 수정
3. 매개값을 VO로 전달  
4. 수정 성공 시 "회원정보가 수정되었습니다." 출력 후 마이페이지로 이동
5. 수정 실패 시 "회원정보 수정에 실패했습니다." 출력 후 마이페이지로 이동 

*/

//URL 강제접속차단  
if (session.getAttribute("user_id")==null) { 
	response.sendRedirect("user_login.jsp");
} 

//1. 폼 값을 받기 
request.setCharacterEncoding("utf-8"); 
String id = (String)session.getAttribute("user_id"); 
String name= request.getParameter("name"); 
String email = request.getParameter("email"); 
String address = request.getParameter("address");

//2. DAO연동을 통해서 update매서드 호출.
UserDAO dao = UserDAO.getInstance(); 
UserVO vo = new UserVO(id, null, name,email, address, null); 

int result= dao.update(vo); 
if (result==1) {  
%> 
	<script> 
	alert("회원정보가 수정되었습니다." ); 
	location.href="user_mypage.jsp"; 
	</script>
<% } else {  %>
	<script>
	alert("회원정보 수정에 실패했습니다."); 
	location.href="user_mypage.jsp"; 
	</script>
	<%} %>



   