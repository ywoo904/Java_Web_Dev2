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
 			
 			if (rs!=null) { 
 				System.out.println(id+"를 출력했습니다.");
 			} else  { 
 				System.out.println(id+"출력하지 못했습니다.");
 			} 
 			
 			while (rs.next()) {
 				String id1 = rs.getString("id"); 
				String pw1 = rs.getString("pw");
				String name1= rs.getString("name"); 
				String email1= rs.getString("email"); 
				System.out.println("---------------------------------------------"); 
				System.out.println("DB로부터 받은 ID값:"+ id1); 
				System.out.println("DB로부터 받은 pw값:"+ pw1); 
				System.out.println("DB로부터 받은 name값:"+ name1); 
				System.out.println("DB로부터 받은 email값:"+ email1); 
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
