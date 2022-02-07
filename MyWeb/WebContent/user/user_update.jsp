<%@page import="com.myweb.user.model.UserVO"%>
<%@page import="com.myweb.user.model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    

<%
	/*
	이 페이지 접근할 때 getUserInfo()메서드를 재활용해서 정보를 불러온 후에 
	input태그에 해당값이 보여지도록 처리. id태그는 변경불가. 

	
	*/
	//URL강제 접속은 거부
	if (session.getAttribute("user_id")==null) { 
		response.sendRedirect("user_id"); 
	}  

	String id= (String)session.getAttribute("user_id"); 
	
	UserDAO dao = UserDAO.getInstance(); 
	UserVO vo= dao.getUserInfo(id);
	
	
	

%>
    
    
 <%@ include file="../include/header.jsp" %> 
    
<section> 
<div align="center"> 
<form name="regform" action= "user_update_ok.jsp"  method="post"> 
<h2>회원가입 페이지</h2>
<table> 
<tr> 
<td>아이디</td> <!--disable을 사용하는 경우 값을 넘기지 않음 -->
<td><input type="text" name="id"  value="<%=vo.getId() %>" readonly></td>
</tr>
 
 <tr>
<td> 이름</td>
<td><input type="text" name="name" value= "<%=vo.getName() %>"> </td>
</tr>

<tr> 
<td> 이메일</td> 
<td><input type="email" name="email"  value="<%=vo.getEmail() %>" > </td>
</tr> 

<tr> 
<td> 주소</td> 
<td><input type="text" name="address"  value="<%=vo.getAddress() %>"    > </td>
</tr>
</table>
<input type="button" value="정보수정" class="btn btn-primary" onclick="check()"> 
<input type="button" value="마이페이지" class="btn btn-info" onclick="location.href='user_mypage.jsp'"> 
</form>
</div>
</section>

<%@ include file="../include/footer.jsp" %>

<script type="text/javascript"> 
	function check () {
		//form은 document.태그이름.태그이름으로 하위태그에 접근이 가능함. 
		//console.log (document.regform.id.value); 을 이용하여 접근확인 가능 
	  if (document.regform.name.value==' ') {   
			alert("이름은 필수사항 입니다.");
	} else if (confirm("회원정보 업데이트를  하시겠습니까?")) { 
			//confirm() 확인창에 "예" 클릭하면 true를 반환, "아니오" 클릭시 false를 반환 
			document.regform.submit(); //자바스크립트를 이용한 submit()기능 
	}}

</script>



</html>