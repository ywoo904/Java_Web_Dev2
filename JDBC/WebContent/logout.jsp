<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% 
    
    //로그아웃 처리는 세션을 삭제 
    session.invalidate(); 
    response.sendRedirect("login.jsp");
    
    
    %>
    <!--   
    또는
    <script> 
    alert("로그아웃되었습니다");
    history.go(-1);
    </script> 
    -->
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>