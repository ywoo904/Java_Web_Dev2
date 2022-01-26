<%--<%@page import="com.bean.User"%>  --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	/*
	  1. 전달받은 값을 처리
	  2. pw와 pw_check값이 같으면 User객체에 quiz01로부터 받은 값을 저장하여 
	     quiz03으로 전달
	     화면 출력 내용 : "id(name)님의 회원 가입을 축하합니다. 비밀 번호가 *****입니다."
	  3. pw와 pw_check값이 틀린 경우, quiz04.jsp로 넘어가서 "회원가입에 실패했습니다." 출력
	
	*/
	request.setCharacterEncoding("utf-8");
    String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String pw_check = request.getParameter("pw_check");
	String name = request.getParameter("name");
	
	if (pw.equals(pw_check)) { %>
	
	<jsp:useBean id="user" class="com.bean.User" scope="request" />
	<jsp:setProperty property="id" name="user" value="<%=id %>" />
	<jsp:setProperty property="pw" name="user" value="<%=pw %>" />
	<jsp:setProperty property="name" name="user" value="<%=name %>" />
	<jsp:forward page="quiz03.jsp" />
	<%--
		User user = new User();
		user.setId(id);
		user.setPw(pw);
		user.setName(name);
		
		request.setAttribute("user", user);
		
		request.getRequestDispatcher("quiz03.jsp").forward(request, response); 
	--%>
	<% }else{  
		response.sendRedirect("quiz04.jsp");
	}

%>
