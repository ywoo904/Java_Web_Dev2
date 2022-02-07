<%@page import="com.myweb.user.model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%
/*
2. login(id,예전비밀번호) 아이디로 비밀번호가 맞는지 확인 
	예전 비밀번호가 틀리면 뒤로가기 
3. 일치하면 changepassword(??)를 실행. 
4. 성공하면 "비밀번호 변경처리 되었습니다."를 출력하고, mypage로 이동
	실패하면 "비밀번호 변경에 실패했습니다."를 출력하고, mypage로 이동
	*/
//강제 url 접속차단 
if (session.getAttribute("user_id")==null) { 
	response.sendRedirect("user_login.jsp");
} 

request.setCharacterEncoding("utf-8"); 
String user_id= (String)session.getAttribute("user_id");
String old_pw = request.getParameter("old_pw"); 
String new_pw= request.getParameter("new_pw");

UserDAO dao = UserDAO.getInstance(); 
int result = dao.login(user_id, old_pw);

if (result==1) { 
	int result1=dao.changepassword(user_id, new_pw); 	 %>
	
	<% if (result1==1)  { %>   
		<script type="text/javascript" >
		alert("비밀번호 변경처리 되었습니다."); 
		location.href="user_mypage.jsp";
		</script>  
		<% 

  	} else  {  %>
		<script type="text/javascript">
		alert("비밀번호 변경에 실패했습니다."); 
		location.href="user_mypage.jsp";
		</script>  
		<% } } else {  %>
	<script>
	history.go(-1);
	</script>  
<%} %> 


	