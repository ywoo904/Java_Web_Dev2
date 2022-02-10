package com.myweb.board.service;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.board.model.BoardDAO;
import com.myweb.board.model.BoardVO;

public class ContentServiceImpl implements IBoardService {

	@Override 
	public void execute(HttpServletRequest request, HttpServletResponse response) {  
		String num= request.getParameter("num"); 
		System.out.println(num);
		
		BoardDAO dao = BoardDAO.getInstance(); 
		
		//쿠키생성: 서버에 요청 시 자동으로 request에 담겨서 전달. 
		Cookie[] arr= request.getCookies();  //생성된 쿠키값을 얻기
		
		//쿠키검사
		boolean bool = true;  
		for(Cookie c: arr) { 
			if(c.getName( ).equals("hitNum"+num)) { //쿠키이름 게시글번호의 쿠키인지 확인
				bool = false;  
				break; 
			} 	
		} 
		//조회수업데이트
		if(bool) { //bool이 true면 클릭한 적이 없다. 
			dao.upHit(num); //hitNum값을 +1해서 업데이트하는 메서드
		}

		BoardVO vo = dao.getContent(num); //결과값을 받아오는 메서드 반환값이 BoardVO
		request.setAttribute("vo",vo); //request에 강제저장
		
		//중복증가를 방지위한 쿠키생성 
		Cookie hitcoo= new Cookie("hitNum"+num, num); //num게시글번호 값으로 쿠키생성
		hitcoo.setMaxAge(60); 
		response.addCookie(hitcoo);
		
	}
}
