<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//예약 설정 확인페이지
	//1. 리스트 2개를 생성(좌석을 저장한 리스트, 사본을 저장할 리스트)
	List<String> list = new ArrayList<>();
	List<String> temp = new ArrayList<>();
	
	//2. app에 예약현황이 있다면 원본 리스트에 저장
	if (application.getAttribute("seats") != null){
		list = (List<String>)application.getAttribute("seats");
	}
	
	//3. reserve.jsp 넘어온 예약 값을 확인
	String[] arr = request.getParameterValues("seat");

	//4. arr에 저장된 값이 list에 포홤되어 있는지 확인. contains(값)
	for (String s : arr) {
		if (list.contains(s)){ //예약이된 경우 
			break; //중단
		} else { //예약되지 않은 경우
			temp.add(s);
		}
	}
	
	//5. arr길이와 temp길이 체크. 같다면 중복된 좌석이 없는 경우, 예약현환(list)에 추가
	if (arr.length == temp.size()) {
		list.addAll(temp);
	} //예약실패시 작업
	
	//6. application에 저장
	application.setAttribute("seats", list);

%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
  </head>
  <body>
    
    <div align="center">
    
    	<h2>예약 신청결과</h2>
    	<p>
    		<b>선택한 좌석</b><br>
    		<%for(String s:arr) {%>
    			[<%=s %>]
    		<%} %>
    		<br><br>
    		<b>예약 신청 결과 :</b>
    		<%= arr.length == temp.size() ? "성공":"실패" %>
    		
    		<br><br>
    		<%if(arr.length != temp.size()) { %>
    			이미 예약된 좌석입니다. 
    		<%} %>
    	</p>
    	
    	<a href="reserve.jsp">다시 예약하기</a>
    
    </div>
  </body>
</html>



