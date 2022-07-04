<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.net.URLEncoder" %>			<!-- import 해주기 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--**response : 내장객체-->
	<!--**sendRedirect : 지정된 주소로 이동 -->
	<!--**?변수명=값 & 변수명=값 : 보내기 -->
	<%
	String name = URLEncoder.encode("유혜리", "utf-8");				/* ("인코딩할문자열","utf-8") */
	response.sendRedirect("redirected.jsp?name="+name+"&age=20"); 
	%>														
</body>
</html>