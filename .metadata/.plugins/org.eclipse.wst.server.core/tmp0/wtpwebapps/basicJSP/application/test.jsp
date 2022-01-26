<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <div align="center">
        <h2>콘서트 예약</h2>
        <h4>예약할 좌석을 선택하세요</h4>
        <hr>

        <form action="reserve_ok.jsp" method="post">
            <b>좌석 배치도</b><br>&nbsp;&nbsp;
            <% for(char c = 'A'; c <= 'Z';c++) {%>
                <small><%=c %></small>&nbsp;&nbsp;
            <% } %><br>
            <% for(int i = 1; i <= 6; i++) {%>
                <%=i %>
                <%for (char c = 'A'; c <= 'Z';c++) {%>
                   
                        <input type="checkbox" name="seat" value="<%=c %>-<%=i %>">
                   
                <% } %>
                <br>
                <% if (i==3) { %>
                    <br>
                <% } %>            
            <% } %>
            <br>

            <input type="submit" value="예약">
            <input type="reset" value="취소">

        </form>


    </div>
</body>
</html>