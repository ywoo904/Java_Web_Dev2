package com.myweb.util;

public class Criteria {
	//mysql, maradb : select * from board by num desc limt ?,?  
	/*
	SELECT * FROM ( 
			SELECT ROWNUM as rnum, NUM, WRITER 
			FROM BOARD 
			WHERE ROWNUM <=?(끝값)   
			order by NUM DESC ) 
			WHERE rnum >=?(시작값) ;
	*/
	private int pageNum; // 페이지번호
	private int count; //몇개의 데이터를 게시판 출력할지 결정 
	
	public Criteria() { 
	//최초 게시판에 진입할 때 기본값 1번 페이지, 10개 데이터 세팅
		this.pageNum = 1;
		this.count= 10; 
	}
	
	public Criteria(int pageNum, int count) { 
	//전달받은 매개변수를 이용한 페이지값 출력	
			super(); 
			this.pageNum= pageNum; 
			this.count = count; 
	}
	//limit x, count y값을 구하는 메서드(RowNum이 +1부터 시작하기 때문)  
	public int getPageStart() {  
		return ((pageNum-1)*count)+1 ;
		
	}

	//Getter, Setter 설정 
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getCount() {
		return count;
	}

	public int getCount_oracle() { //쿼리에 따라서 첫번째 "?"의 값이 증가하기 때문에 설정 
		return (pageNum*count); 
	}
	
	public void setCount(int count) {
		this.count = count;
	} 
	
	
	
	
	
	
}
