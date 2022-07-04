<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
</head>
<body>
	<!-- EL의 장점 : import생략가능 (여기서는 ArrayList를 생략함) -->
	<c:forEach var="fruit" items="${s}" >
		${fruit}<br>	
	</c:forEach>
</body>
</html>