package com.ok;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {
	/*
	 * DAO는 단수 DB연동을 담당하는 클래스  
	 * 여러개 생성하지 않도록 일반클래스로 만들면 메모리 과부하가 올 수 있음 
	 * 싱글톤 패턴을 적용하여 객체를 1개로 제한함 
	 */
	
	//1. 스스로의 객체를 멤버변수로 선언하고 1개로 제한 
	private static MemberDAO instance = new MemberDAO();
	
	//2. 외부에서 객체를 생성할 수 없도록 생성자에 private 처리 
	private MemberDAO()  { 
	//생성자가 한번 동작할 때에 다음 내용을 처리... 	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
		} catch (Exception e) {
			System.out.println("드라이버 호출 시 에러발생");
		}
	}
	
	//3.외부에서 객체를 요구할 때 getter메서드만 써서 반환  
	public static MemberDAO getInstance() { 
		return instance;
		
	} 
	//DB연동을 위해서 필요한 변수와 객체선언 
	private String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
	private String user = "myjsp"; 
	private String password = "myjsp"; 
	
	private Connection conn = null; 
	private PreparedStatement pstmt = null; 
	private ResultSet rs= null; 
	
	//-------------------------기능을 매서드로 선언하는 부분 --------------------- 
	//회원가입메서드 
	public int join(MemberVO vo ) {
		int result = 0; 
		String sql = "INSERT into testusers values (?,?,?,?,?,?,?)";
		
		try {
			//Connection 객체생성 
			conn= DriverManager.getConnection(url,user,password);
			
			//PreparedStatement 객체생성 
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getPhone1());
			pstmt.setString(5, vo.getPhone2());
			pstmt.setString(6, vo.getEmail());
			pstmt.setString(7, vo.getGender());
			
			//SQL 실행 
			result= pstmt.executeUpdate( );
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally { 
			try {
				if(conn!=null) conn.close() ; 
				if(pstmt!=null) pstmt.close();
				
			} catch (Exception e2) {
			} 
		}  
		return result; 
		}
	
	//로그인메서드 
	public int login(String id, String pw) { 
		int result=0 ;
	
		String sql= "select *from testusers where id=? and pw=?"; 
		
		try {
			conn = DriverManager.getConnection(url,user,password);
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs= pstmt.executeQuery(); 
			
			if (rs.next()) result=1; 
			
		} catch (Exception e) {
		 e.printStackTrace();
		} finally {  
			try { 
				if (conn!=null) conn.close();
				if(pstmt!=null) pstmt.close(); 
				if(rs!=null) rs.close(); 				
			} catch (Exception e2) {  }
			
		} 
		
		return result;
		
	} 
	
	//회원정보 조회메서드
	public MemberVO getInfo(String id) {
		MemberVO vo = null;
		
		String sql = "select * from testusers where ID=?";
		
		try {
			//Connection객체생성 
			conn =DriverManager.getConnection(url, user, password); 
			//PreparedStatement객체생성 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id); 
			//SQL쿼리실행 
			rs= pstmt.executeQuery(); 
			
			while(rs.next()) { 
				//rs.getString(컬럼명)을 통해 값을 얻어오는 코드
				String name= rs.getString("name"); 
				String pw = rs.getString("pw");
				String phone1= rs.getString("phone1");
				String phone2= rs.getString("phone2"); 
				String email = rs.getString("email"); 
				String gender = rs.getString("gender"); 
				
				vo= new MemberVO(id, pw, name, phone1, phone2, email, gender);
			} 
			
			
		} catch  (Exception e) { 
			e.printStackTrace();
		} finally {  
			try { 
				if (conn!=null ) conn.close(); 
				if(pstmt!=null) pstmt.close(); 
				if(rs!=null) rs.close() ; 
				
			} catch (Exception e2 ) {  }
		} 
		
		return vo ;
		
	}   
//Update메서드 
	public int update(MemberVO vo) { 
		int result = 0;
		
		String sql = "update testusers set pw=?, name=?, phone1=?, phone2=?, email=?, gender=? where id=?";
		
		try { 
			//커넥션 
			conn = DriverManager.getConnection(url,user,password); 
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1,vo.getPw()); 
			pstmt.setString(2,vo.getName()); 
			pstmt.setString(3,vo.getPhone1()); 
			pstmt.setString(4,vo.getPhone2());
			pstmt.setString(5,vo.getEmail());
			pstmt.setString(6, vo.getGender()); 
			pstmt.setString(7,vo.getId()); 
			
			result=pstmt.executeUpdate() ;
			} catch (Exception  e ) { 
			e.printStackTrace();
		} finally  { 
			try { 
				if (conn!=null) conn.close() ;
				if(pstmt!=null) pstmt.close();
			} catch (Exception e2) {
				
			} 
		} 
		return result; 
		
	}
	
	
	
	
	
	
}
		
	
	
	