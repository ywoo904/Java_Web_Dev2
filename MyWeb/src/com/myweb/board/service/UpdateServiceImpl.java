package com.myweb.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.board.model.BoardDAO;
import com.myweb.board.model.BoardVO;

public class UpdateServiceImpl implements IBoardService {

	@Override 
	public void execute(HttpServletRequest request, HttpServletResponse response) {  
		//board_modify form 태그에서 값 가져오기
		String num= request.getParameter("num"); 
		String title= request.getParameter("title");
		String content= request.getParameter("content");
		//다오 객체생성
		BoardDAO dao = BoardDAO.getInstance(); 
		int result= dao.update(num, title, content); 
		
		if(result==1) { 
			System.out.println("수정이 완료되었습니다.");
			
		} else  { 
			System.out.println("수정에 실패했습니다. ");
			
		}
		
		
	}
	
}
