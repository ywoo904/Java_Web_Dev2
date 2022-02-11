<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@include file="../include/header.jsp" %>
    
    
<!DOCTYPE html>
<html>


	<section>
	<div align="center"> 
	<form name="regform"  action="update.board"  method="post" > 
		<table border= "1 "  width="500">
			<tr> 
			<td >글번호</td>
			<td><input type= "text" name="num" value="${vo.num }" readonly> </td>
			</tr> 
		
		<tr> 
		<td>작성자</td>
				<td><input type= "text" name="writer" value="${vo.writer }" readonly></td>
		</tr>

			<tr> 
				<td>제목</td> 
			<td><input type= "text" name="title" value="${vo.title }"></td>
			</tr>		
			
			<tr> 
				<td>내용</td> 
				<td colspan="3" height="120"> 
				<textarea name="content" rows="10"  style="width:100%;">
				${vo.content }
				</textarea>
 					</td>
			</tr>
			
			<tr> 
				<td colspan="2" align="center">
					<input type="button" value="목록" onclick="location.href='list.board'">
					<input type="button" value=" 확인"  onclick="modifyCheck()" > 		
					<input type="button" value=" 삭제"  onclick="confirm('삭제하시겠습니까?')? location.href='delete.board?num=${vo.num}' : ''  "  >	
				  </td>
			</tr>
		</table>
	</form>
	</div>
	</section>

  <%@include file="../include/footer.jsp" %>
  
  <script type="text/javascript"> 
	function modifyCheck() {
		//작성자, 글제목에 공백을 확인하고, 공백이 아니라면 submit() 처리
		 if(confirm("게시글을 수정하겠습니까?")) {
			document.regform.submit( ); 
		}
		
	}
	
</script>
  
    
</body>
</html>