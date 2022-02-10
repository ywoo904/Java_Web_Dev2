package com.myweb.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.board.model.BoardDAO;

public class RegisterServiceimpl implements IBoardService{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse resposne) { 
		
		//폼에서 전달된 값을 처리 
		String writer= request.getParameter("writer"); 
		String title= request.getParameter("title");
		String content= request.getParameter("content");
		
		//DAO 객체생성
		BoardDAO dao = BoardDAO.getInstance(); 
	
		//regist 매서드호출 
		int result = dao.regist(writer,title,content); 
		
		if(result==1) { 
			System.out.println("수정이 완료되었습니다.");
			
		} else  { 
			System.out.println("수정에 실패했습니다. ");
			
		}
		
		
		
	} 
	
	
}
