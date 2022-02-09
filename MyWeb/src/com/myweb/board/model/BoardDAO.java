package com.myweb.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.myweb.util.JdbcUtil;

public class BoardDAO {

	
	
	//1. 스스로 객체를 멤버변수로 선언하고 1개 제한- 싱글톤
	private static BoardDAO instance= new  BoardDAO(); 
	
	 
	
	//2. 외부에서 객체를 생성할 수 없도록 생성자에 private처리  
	private BoardDAO() {
		try { 
			//Context.xml값에 저장된 설정을 저장하기 위해서 
			InitialContext ctx = new InitialContext(); 
			ds =  (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");   
		} catch  (Exception e) {
			System.out.println("커넥션 풀링 에러발생");
			
		} 
	} 
	
	//3. 외부에서 객체를 요구할 떄 getter메서드만 써서 반환 
	public static BoardDAO getInstance() { 
		return instance; 	
	}
	//---------------------------중복되는 코드 멤버변수 선언--------------------------
	private DataSource ds; 
	private Connection conn = null; 
	private PreparedStatement pstmt = null; 
	private ResultSet rs= null; 
	
	//-----------------------------------메서드 구현------------------------------------
	public int regist(String writer, String title, String content) { 
		int result=0;
		String sql = "INSERT INTO board (WRITER, TITLE, CONTENT) VALUES(?,?,?)"; 
		try { 
			conn =ds.getConnection(); //커넥션객체생성
			pstmt= conn.prepareStatement(sql); //PreparedStatement객체생성 
			pstmt.setString(1,writer);  
			pstmt.setString(2, title); 
			pstmt.setString(3, content); 
			result= pstmt.executeUpdate(); 
		} catch (Exception e) { 
			e.printStackTrace();  
		} finally { 
			try { 
				JdbcUtil.close((conn), pstmt, rs);
			} catch (Exception e2) { } 
		} 
		return result; 

	}  
	
	//게시물목록 조회 메서드
	public ArrayList<BoardVO> getList(  ) { 
		ArrayList<BoardVO> list= new ArrayList<BoardVO>();
		
		String sql= "select * from board order by num desc";  //게시글 번호 내림차순
		try { 
			conn =ds.getConnection(); //커넥션객체생성
			pstmt= conn.prepareStatement(sql); //PreparedStatement객체생성 
			rs= pstmt.executeQuery(); 
			while (rs.next()) { 
				//rs.getString(컬럼명), rs.getInt(), rs.getTimeStamp( ) 
				//데이터를 vo에 담고, 이 데이터를 list에 저장할 코드를 작성 
				/*
				 * Board vo = new BoardVO(); 
				 * vo.setNum(rs.getInt("num"); 
				 * vo.setWriter(rs.getString("writer"); 
				 * vo.setTitle(rs.getString("title"); 
				 * vo.setContent(rs.getString("content"); 
				 * vo.setRegdate(rs.getTimeStamp("regdate"); 
				 * vo.setHit(rs.getInt("hit"); 
				 * */ 
				int num= rs.getInt("num"); 
				String writer = rs.getString("writer") ; 
				String title= rs.getString("title"); 
				String content= rs.getString("content");
				Timestamp regdate = rs.getTimestamp("regdate");
				int hit = rs.getInt("hit");
				
				BoardVO vo = new BoardVO( num, writer,title, content,regdate,hit); 
				
				list.add(vo); 

			}
			
		} catch (Exception e) { 
			e.printStackTrace();  
		} finally { 
			try { 
				JdbcUtil.close((conn), pstmt, rs);
			} catch (Exception e2) { } 
		} 
		
		
		
		return list; 
		
	} 
	
	
	
	
	
	
	
	
	
	
}
