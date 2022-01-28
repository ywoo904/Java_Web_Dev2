package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JDBCPinsert {

	public static void main(String[] args) {
		//입력값 받는 처리(member) 
		Scanner sc = new Scanner(System.in); 
		System.out.println("id>"); String id = sc.next(); 
		System.out.println("pw>"); String pw = sc.next(); 
		System.out.println("name>"); String name = sc.next(); 
		System.out.println("email>"); String email = sc.next(); 
		
		//연결에 필요한 변수
		String url= "jdbc:oracle:thin:@localhost:1521/XEPDB1"; 
		String user= "myjsp"; 
		String password ="myjsp"; 
		
		//객체생성:
		Connection conn = null; 
		PreparedStatement pstmt =  null;
		
		String sql = "insert into member values(?,?,?,?)";  
		
		try { 
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			conn= DriverManager.getConnection(url,user,password); 
			
			pstmt = conn.prepareStatement(sql);
			//pstmt 객체에 값을 설정 시 getString, setInt, setDouble
			//불러올경우  
			pstmt.setString(1,id ); 
			pstmt.setString(2,pw ); 
			pstmt.setString(3,name);
			pstmt.setString(4,email );
			
			//pstmt실행(성공시 1을, 실패시 1을 반환)  
			int result = pstmt.executeUpdate();
			//
			if(result==1) { 
				System.out.println("입력성공");
			} else { 
				System.out.println("입력실패");
			}  
			
		} catch (Exception e) { 
			e.printStackTrace(); 
		} finally {  
			try { 
				if(conn!=null) conn.close(); 
				if(pstmt!= null) pstmt.close();  
				
				
			} 
			catch(Exception e2) { } 
			
		} 
		
		
		
		
		
		
	}

}
