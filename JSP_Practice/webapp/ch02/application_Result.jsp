<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String message=(String)application.getAttribute("message");
	out.println("메시지 : " + message + "<br>");	// 이렇게 출력하거나
	%>
	메시지 : ${applicationScope.message}			<!--이렇게 출력하거나--> 
</body>
</html>