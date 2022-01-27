package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCInsert {
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//입력값을 받는 코드 
		Scanner sc = new Scanner(System.in);  
		System.out.println("id>"); String id = sc.next(); 
		System.out.println("pw>"); String pw= sc.next(); 
		System.out.println("name>"); String name = sc.next(); 
		System.out.println("email>"); String email=sc.next();  
		
	 //	System.out.println("입력아이디:  "+id+"\n입력암호: "+pw+"\n입력이름: "+name +"\n입력이메일:" +email);
		String url= "jdbc:oracle:thin:@localhost:1521/XEPDB1";  //oracle URL 
		String uid ="myjsp";
		String upw="myjsp";
		Connection conn = null; 
		Statement stmt= null; 
		//resultSet 객체는 선언안함..why? Select구문에서만 사용.  
		
		//SQL 구문: INSERT INTO MEMBER values ('id','pw','name', 'email');   
		String sql = "Insert into member values('"+id+"',  '"+pw+"', '"+name+"', '"+email+"' )"; 
		
		//1. JDBC 드라이버 호출 
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		 
		 //2. Connection 객체를 생성 
		 DriverManager.getConnection(url,uid, upw); 
		
		 //3. SQL쿼리를 전달할 Statement 객체를 생성 
		 stmt = conn.createStatement(); 
		 
		 //4. Statement 객체에 SQL을 포함하여 전달. 
		 int result= stmt.executeUpdate(sql); 
		 
		 if (result==1)  { 
			 System.out.println("입력성공");
		 } else { 
			 System.out.println("입력실패");
		 } 
		 
		 // 5. 객체종료 
		 conn.close(); 
		 stmt.close(); 
		 
	
	}
	
	

}
