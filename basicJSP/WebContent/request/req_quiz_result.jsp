<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	double kie = Double.parseDouble(request.getParameter("kie"));
	double weight = Double.parseDouble(request.getParameter("weight"));
	//BMI 계산 공식 => kg / (cm/100 * cm/100)
	double BMI = weight / (kie/100 * kie/100);
	
	BMI = (int)(BMI * 100) / 100.0;  //연산을 통해서 자리수를 잘라내는 방식
	   
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    이름 : <%=name %><br>
    신장 : <%=kie %><br>
    몸무게 : <%=weight %><br>
    BMI : <%=BMI %><br>
    <%
    if (BMI > 25){%>
    	과체중입니다. 
    <%} else if (BMI < 18) { %>
    	저체중입니다.
    <%} else { %>
    	정상입니다. 
    <%} %>
</body>
</html>