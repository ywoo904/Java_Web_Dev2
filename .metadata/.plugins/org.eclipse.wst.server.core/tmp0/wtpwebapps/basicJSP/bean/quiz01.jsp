<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%--ID와 PW,Name을 입력받아서 처리하는 부분 --%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
  </head>
  <body>
    
    <form action="quiz02.jsp" method="post">
      ID : <input type="text" name="id" size="10"><br>
      PW : <input type="password" name="pw" size="10"><br>
      PW확인 : <input type="password" name="pw_check" size="10"><br>
      이름 : <input type="text" name="name" size="10"><br>
      <input type="submit" value="회원가입">
    </form>
    
  </body>
</html>