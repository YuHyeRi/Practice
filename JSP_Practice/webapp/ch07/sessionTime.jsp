<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 유효시간</title>
</head>
<body>
	<h2>세션의 유효시간 설정</h2>		<!-- 세션의 유효시간은 초단위, 톰캣 기본값 1800초(30분) -->
	<%
	// session.setMaxInactiveInterval(600);		
	// 현재 web.xml에 15분(900초)로 설정해두었기 때문에 900이 출력됨
	int timeout = session.getMaxInactiveInterval();
	out.println("세션의 유효시간 : " + timeout);
	%>
</body>
</html>