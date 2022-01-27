<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <% 

  Connection conn= null; 
  String driver="oracle.jdbc.driver.OracleDriver"; //DB드라이버. 
  String url ="jdbc:oracle:thin:@localhost:1521/XEPDB1"; //DB connection 작업 중 url 값. 
  /*
  <DRIVER>  
  MySQL (6이후): com.mysql.cj.jdbc.Driver 
  MySQL (6이전): com.mysql.jdbc.Driver 
  MariaDB: org.mariadb.jdbc.Driver 
  
  <URL 설정>
  Oracle: jdbc:oracle:thin:@[서버주소(IP또는 도메인)]:[서비스포트(1521)]/[세션 or 계정명]
  MySQL (6이후) : jdbc:mysql://[서버주소(IP또는 도메인)]:[서비스포트(3306)]/ [DB이름] ?serverTimezone=UTC 
  MySQL (6이전): jdbc:mysql://[서버주소(IP또는 도메인)]:[서비스포트(3306)]/ [DB이름] 
  서울의 UTC = Asia/Seoul
  Mariadb: jdbc:mysql://[서버주소(IP또는 도메인)]:[서비스포트(3306)]/ [DB이름]      */
  
  String user="hr";
  String pw ="hr"; 
  
  Boolean connect = false; 
  
  try { 
	  //1. 드라이버 로딩 
	  Class.forName(driver); 
	  
	  //2. db연결
	  conn = DriverManager.getConnection(url,user, pw); 
	  connect =true; 
  } catch (ClassNotFoundException cnfe) {
	  //Driver로딩실패 
	  connect= false; 
	  System.out.println ("DB드라이버 로딩실패: "+ cnfe.toString()); 
  } catch (SQLException sqle) { 
	  //DB 연결 
	  connect= false; 
	   System.out.println ("DB드라이버 로딩실패: "+ sqle.toString());
  } catch(Exception e) { 
  //Unknown error 
  		connect= false; 
  		System.out.println("Unknown error"); 
  		e.printStackTrace(); 
  }
  		
  		if(connect==true) { %> 
  			<h2> 연동성공</h2>
  		<%} else { %> 
  		<h2> 연동실패</h2>
  		<%} %>
  		
    
 
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>





</body>
</html>