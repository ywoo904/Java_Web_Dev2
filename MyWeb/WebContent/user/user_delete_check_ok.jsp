<%@page import="com.myweb.user.model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
if (session.getAttribute("user_id")==null) { 
	response.sendRedirect("user_login.jsp");
} 

	//1.user_delete_check.jsp로 받은 폼데이터 값을 처리 
	request.setCharacterEncoding("utf-8"); 
	String userid=(String)session.getAttribute("user_id");
	String pw= request.getParameter("pw"); 
	
	UserDAO dao= UserDAO.getInstance();  
	//2. login(id,pw) 메서드를 재사용하여 비밀번호를 확인 
	int result = dao.login(userid, pw); 
	
	/*3. login 메서드가 0을 반환하면 비밀번호를 확인하세요. 라고 출력 
	login 메서드가 1을 반환하면, delete() 메서드를 실행 */
	if(result==0) { %> 
	 <script>
	 alert("비밀번호를 확인하세요."); 
	 location.href="user_mypage.jsp";
	 </script> 	
	<%} else { 
	int result1=dao.delete(userid); 
	/*4. 삭제 성공 시 "회원탈퇴처리가 되었습니다" 출력. 세션 전부 삭제 => /MyWeb으로 이동  
	삭제 실패 시 "회원탈퇴에 실패했습니다"를 출력. 마이페이지로 이동.  
	sql =" delete from users where id = ? " 세션을 통해서 강제접근 거부  */
	if(result1==1) {  
		session.invalidate();
	%> 
		<script> 
		alert("회원탈퇴처리가 되었습니다. "); 
		location.href= "/MyWeb/";
		</script>

<% }  else { %>
		<script> 
		alert("회원탈퇴에 실패했습니다");   
		location.href="mypage.jsp";
		</script>


<%} %>	 

 <% } %>
	



    
    
    