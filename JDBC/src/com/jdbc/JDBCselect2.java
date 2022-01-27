package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCselect2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url= "jdbc:oracle:thin:@localhost:1521/XEPDB1"; 
		String uid = "myjsp" ;
		String upw = "myjsp";
		Connection conn = null; 
		Statement stmt =null; 
		ResultSet rs = null; 
		
		String sql ="SELECT * from member";
		
		try { 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn= DriverManager.getConnection(url, uid, upw);
			stmt= conn.createStatement(); 
			rs=stmt.executeQuery(sql);
			
			if (rs!=null) {  
				System.out.println("드라이버로딩성공");
			} else { 
				System.out.println("드라이버로딩실패 ");
			}
			
			
			while(rs.next()) {  
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
			
			
		} catch(ClassNotFoundException cnfe ) { 
			System.out.println("드라이버를 로드하지 못함"+ cnfe.toString( ));
		} catch (SQLException sqle) { 
			System.out.println("DB연결 또는 SQL구문에러"+ sqle.toString());
		} catch (Exception e) {  
			e.printStackTrace(); 
		} finally {   
			try { 
				if (conn!=null) conn.close(); 
				if (stmt!=null) stmt.close(); 
				if(rs!=null) rs.close(); 
			} catch (Exception e2) { } 
			
		} 
		
		
		
		
	}
	
	
	
	
}

