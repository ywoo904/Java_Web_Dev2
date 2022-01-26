<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//쿠키 사용하기
	//쿠키는 요청시 자동으로 전송되고 request에 자동으로 저장됨. 
	
	Cookie[] arr = request.getCookies();

	if (arr != null) {  //쿠기가 null이 아닌 경우 실행(존재할 경우)
		
		for(int i = 0; i < arr.length; i++ ) {
			
			out.println(arr[i].getName()+"<br>");  // 쿠키 이름을 얻기
			out.println(arr[i].getValue()+"<br>"); // 쿠키 값을 얻기
			out.println("<br>");
		}
	}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>