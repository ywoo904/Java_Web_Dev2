<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	/*
	 세션은 쿠기와 마찮가지로 인증정보를 유지하기 위해서 사용하는, JSP내장 객체
	 설정은 setAttribute("이름",값)으로 저장합니다. 
	*/
	
	session.setAttribute("id", "kkk123");
	session.setAttribute("name", "홍길자");

    Enumeration<String> attrNames = request.getAttributeNames();                
    
    while(attrNames.hasMoreElements()){
          String attrName = attrNames.nextElement();
          Object attrValue = request.getAttribute(attrName);
          System.out.println(attrName + " : " + attrValue);
    }

%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
  </head>
  <body>
    <a href="session_get.jsp">세션확인하기</a>
  </body>
</html>