package com.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCdelete {

	public static void main(String[] args)  {
	
		Scanner sc= new Scanner(System.in);
		System.out.print("삭제할 id:  "); String id = sc.next(); 
		
		//DB연결위한 URL, UID, UPW, 드라이버 
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url= "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String uid = "myjsp"; 
		String upw ="myjsp"; 
		
		//DB연동을 위한 객체 
		Connection conn = null; 
		Statement stmt= null; 
		
		//SQL구문 
		String sql = "delete from member where id='"+id+"'"; 
		
		try { 
			//1. Driver Loading 
			Class.forName(driver); 
			//2. Connection
			conn = DriverManager.getConnection(url,uid, upw); 
			//3. SQL 쿼리를 처리할 statement 객체생성
			stmt = conn.createStatement(); 
			//4.SQL 구문실행 
			int result =  stmt.executeUpdate(sql);			
			
			if (result ==1) {
				System.out.println(id+ "가 삭제되었습니다");
			} else {
				System.out.println("삭제실패");
			} 
			
		} catch (Exception e )  { 
				e.printStackTrace() ;
		} finally  { 
			try { 
				if  (conn!= null) conn.close(); 
				if  (stmt !=null) stmt.close(); 
			}catch (Exception e) { } 
		} 
		
		
		
		
	}
	
	
}
