package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCquiz01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in); 
		System.out.print("출력할 ID: "); String id = sc.next(); 
		
		String driver= "oracle.jdbc.driver.OracleDriver"; 
		String url= "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String uid = "myjsp"; 
		String upw = "myjsp"; 
		
		Connection conn = null; 
		Statement stmt = null ;
		ResultSet rs = null;
		
		String sql = "SELECT * from member where ID='"+id+"'";
		
		try {  
			Class.forName(driver) ; 
			conn= DriverManager.getConnection(url,uid,upw); 
			stmt= conn.createStatement(); 
 			rs= stmt.executeQuery(sql); 
 			
 			if (rs.next ( )) {
 				String id1= rs.getString("ID"); 
 				String pw1 = rs.getString("PW");
 				String name1=  rs.getString("NAME");
 				String email1= rs.getString("EMAIL");
 				System.out.println("------------검색한 ID:  "+id+"님 정보--------------");
 				System.out.println("아이디는" + id1);
 				System.out.println("패스워드는" + pw1);
 				System.out.println("이름은" + name1);
 				System.out.println("이메일은" + email1);
 			} else {  
 				System.out.println(id+ "는 없습니다");
 				
 			} 	
 				
		} catch  (Exception e) { 
			e.printStackTrace(); 
		} finally  {  
			try { 
			if (conn!=null) conn.close(); 
			if(stmt!=null) stmt.close (); 
			if (rs!=null) rs.close (); 
			} catch (Exception e) { } 
		} 
		
	}
	
	
	
	
}
