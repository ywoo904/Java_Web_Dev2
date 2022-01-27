package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCdelete {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url= "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String uid= "myjsp"; 
		String upw= "myjsp"; 
		Connection conn = null;
		Statement stmt = null; 
	
		
		Scanner sc= new Scanner (System.in ); 
		System.out.println("삭제하고자 하는 아이디를 입력하세요");
		String ID2 = sc.next();
		String sql = "Delete From member where ID='"+ID2+"'"  ; 
		//드라이버 시동
		System.out.println(sql);
	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, uid, upw); 
		
		stmt = conn.createStatement(); 
		
		int result= stmt.executeUpdate(sql); 
		
		 if (result==1)  { 
			 System.out.println("입력성공");
		 } else { 
			 System.out.println("입력실패");
		 } 
		
		conn.close(); 
		stmt.close ();

	}
	
	
}
