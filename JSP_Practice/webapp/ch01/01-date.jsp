<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Date" %>
<%@ page import = "java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	Date nowDate = new Date();
	out.println(nowDate + "<br>");
	/* yyyy:연도, MM:월, dd:날짜, HH:24시간, hh:12시간 mm:분, ss:초 */
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 a HH:mm:ss");
	String formatDate = dateFormat.format(nowDate);
	%>
	현재 날짜는 <%=formatDate%>
</body>
</html>