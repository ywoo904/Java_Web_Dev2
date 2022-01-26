<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*
		1. 앞에서 전달 받은 폼값을 받아서 평균을 구한다. 
		2. 평균의 값이 60점 이상이면 score_quiz03.jsp로 이동
		  "OOO님 평균 XX점 합격입니다."가 출력되게 합니다.
		3. 평균의 값이 60점 미만이면 score_quiz04.jsp로 이동
		"OOO님 평균 XX점 불합격입니다."가 출력되게 합니다.
	
	*/
	request.setCharacterEncoding("utf-8");
	
	String name = request.getParameter("name");
	String sKo = request.getParameter("ko");
	String sEn = request.getParameter("en");
	String sMath = request.getParameter("math");
	
	int ko = Integer.parseInt(sKo);
	int en = Integer.parseInt(sEn);
	int math = Integer.parseInt(sMath);
	
	double avg = (double)(ko + en + math) / 3;
	
	String path = "";
	
	if (avg >= 60) {
		path = "score_quiz03.jsp";
	}else {
		path = "score_quiz04.jsp";
	}
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
  </head>
  <body>
   	<jsp:forward page="<%=path %>">
   		<jsp:param value="<%=name %>" name="name"/>
   		<jsp:param value="<%=avg %>" name="avg"/>
   	</jsp:forward>
  </body>
</html>








