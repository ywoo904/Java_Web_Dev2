package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCtest {

	public static void main (String[] args) {    
	
	//오라클 설정,사용자DB접속 계정정보 
	String driver_oracle = "oracle.jdbc.driver.OracleDriver";      //오라클 드라이버로딩 
	String url_oracle= "jdbc:oracle:thin:@localhost:1521/XEPDB1"; //또는 IP 주소도 입력가능( cmd에서 확인)  
	String user = "myjsp"; 
	String password  ="myjsp"; 

	//마리아DB설정 //MariaDB 사용자 설정: 
	String driver_mariadb = "org.mariadb.jdbc.Driver";
	String url_mariadb ="jdbc: mysql://localhost:3306/testdb"; 
	String m_user="root";
	String  m_password="0000"; 
	
	
	//연결확인 위한 객체생성 	//connection 값을 판별하는 boolean값
	Connection conn = null;
	Boolean connect = false; 
	
	try { 
		//1. 드라이버 로딩  
		Class.forName(driver_oracle); //Class.forName(driver_mariadb);
		//2. DB연결 
		conn = DriverManager.getConnection(url_oracle, user, password); //conn= DriverManager.getConnection(url_mariadb, m_user, m_password);
		connect = true; 
	} catch (ClassNotFoundException cnfe) { 
		 //1.드라이버로딩이 안될때 
		connect= false; 
		System.out.println("DB드라이버 로딩실패:"+ cnfe.toString() );
	}  catch(SQLException sqle) {
		//2. Connection 실패시 에러(SQL Exception)  
		connect = false; 
		System.out.println("DB접속 실패"+sqle.toString());
	} catch (Exception e) { 
		//Unknown 에러 
		connect= false;
		System.out.println("Unknown Error");
		e.printStackTrace();
	}  
	
	if (connect) { 
		System.out.println("연결성공");
	} else {  
		System.out.println("연결실패");
	}
}} 
