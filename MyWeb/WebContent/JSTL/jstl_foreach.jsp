<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- jstl의 변수선언 -->
<c:set var="sum" value="0" /> 

<c:forEach var="i"  begin="1" end="100" step="1"> 
	<c:set var="sum"  value ="${sum+i}"/> 
</c:forEach>

결과: ${sum} <br>  
결과: <c:out value="${sum}"></c:out>

<hr>  

<h2> 구구단 3단 출력</h2>
<h3>3단출력</h3>
<c:forEach var="i"  begin="1" end="9" step="1"> 
<c:set var="num" value="3" /> 
<c:set var="result"  value ="${num*i}"/> 
	3* ${i} = ${result} <br>
</c:forEach>

<hr> 

<h2> 모든 구구단 출력 </h2>
<c:forEach var="i"  begin="2" end="9" step="1"> 
	<h3>${i }단 출력</h3>
<c:forEach var="j"  begin="1" end="9" step="1"> 
	${i}* ${j} = ${i*j} <br><br>
</c:forEach>
</c:forEach>

<hr> 

<h2>향상된 for문</h2>
<% 
	
	int [] arr = {1,2,3,4,5,6}; 
	for(int a:arr) { 
		out.println(a); 
	} 
%>
	<br> 
	<h3> jstl을 이용한 향상된 for문</h3>
	<c:set var="arr2" value=" <%=new int[ ] {1,2,3,4,5,6}%>" /> 
	<c:forEach var="i " items="${arr2}"> 
		${i}
	</c:forEach>
	

</body>
</html>