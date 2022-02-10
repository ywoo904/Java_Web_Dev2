<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>

    <%@include file="../include/header.jsp" %>

	<section>
	<div align="center"> 
	<form action="#"   > 
		<table border= "1 "  width="500">
			<tr> 
			<td width="20%">글번호</td>
			<td width="30%">${vo.num }</td> <!-- DB로 부터 데이터 전달받을 부분  -->
			<td width= "20%">조회수</td> 
			<td width= "30%">${vo.hit}</td>
			</tr> 
			
			<tr>
				<td>작성일</td> 
				<td>${vo.regdate }</td> <!-- DB로 부터 데이터 전달받을 부분  -->
				<td>작성자</td>
				<td>${vo.writer }</td><!-- DB로 부터 데이터 전달받을 부분  -->
			</tr>
		
			<tr> 
				<td>제목</td> 
				<td colspan="3">${vo.title} </td><!-- DB로 부터 데이터 전달받을 부분  -->
			</tr>		
			
			<tr> 
				<td>내용</td> 
				<td colspan="3" height="150">${vo.content } </td>  <!-- DB로 부터 데이터 전달받을 부분  -->
			</tr>
			
			<tr> 
				<td colspan="4" align="center">
					<input type="button" value="목록" onclick="location.href='list.board'">
					<input type="button" value=" 수정"  onclick="location.href='modify.board?num=${vo.num}'"> 			
				  </td>
			</tr>
		</table>
	</form>
	</div>
	</section>





   <%@include file="../include/footer.jsp" %>
</body>
</html>