<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	//String email = request.getParameter("email");
	
%> 

<%--
	액션 태그를 사용한 빈(객체) 사용방법
    id = 사용할 변수명
    class = 실제경로
    scope = 빈의 사용범위

 --%>   

<jsp:useBean id="u1" class="com.bean.User" scope="page" />

<%--setProperty의 setter설정을 모두 처리함 --%>
<jsp:setProperty property="*" name="u1" />

<%--setProperty는 setter메소드 사용 --%>
<%--
<jsp:setProperty property="id" name="u1" value="<%=id %>" />
<jsp:setProperty property="pw" name="u1" value="<%=pw %>" />
<jsp:setProperty property="name" name="u1" value="<%=name %>" />
<jsp:setProperty property="email" name="u1" value="<%=email %>" />
 --%>

<%--getProperty는 getter메소드 사용 --%>
입력한 아이디 : <jsp:getProperty property="id" name="u1" /><br>
입력한 패스워드 : <jsp:getProperty property="pw" name="u1" /><br>
입력한 이름 : <jsp:getProperty property="name" name="u1" /><br>
입력한 이메일 : <jsp:getProperty property="email" name="u1" /><br>


