<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

     <%@ include file="../include/header.jsp" %> 
 
<!-- 
1. MyWeb 사이트와 연동되어야함.   
2. 로그인 시 필요한 아이디와 비밀번호를 입력받게 설정  
3. 로그인 버튼과 회원가입 버튼을 생성 
-->
<section> 
<div align = "center"> 
<h2>로그인페이지</h2> 
<hr>   
<form action="user_login_ok.jsp" method="post">  
<table>
<tr>  
<td> <input type="text" name="id" placeholder="아이디" ></td>
</tr>
<tr> 
<td> <input type="password" name="pw" placeholder="비밀번호"></td>
</tr>
</table>
<input type= "submit"  value="로그인"  class= "btn btn-info"> 
<input type= "button"  value="회원가입" class="btn btn-primary" onclick="location.href='user_join.jsp'"  >  

</form>
</div>
</section>

<%@ include file="../include/footer.jsp" %>
