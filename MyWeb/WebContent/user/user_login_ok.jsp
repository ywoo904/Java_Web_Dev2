<%@page import="java.sql.Timestamp"%>
<%@page import="com.myweb.user.model.UserVO"%>
<%@page import="com.myweb.user.model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%
  	//form태그값처리
    request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");  
	String pw = request.getParameter("pw");  

	//DAO객체생성
	UserDAO dao = UserDAO.getInstance(); 
	int result = dao.login(id, pw);
	
	if(result==1) { 
		UserVO vo= dao.getUserInfo(id);
		String name =vo.getName(); 
		
		//아이디와 이름을 세션에 저장
		session.setAttribute("user_id",id);
		session.setAttribute("user_name",name);
	
		response.sendRedirect("user_mypage.jsp"); 
		
	} else {  %>
		<script type="text/javascript"> 
		alert("아이디 또는 비밀번호가 잘못되었습니다.");
		history.go(-1); //뒤로가기
		</script>
	
	<% }%>









</html>