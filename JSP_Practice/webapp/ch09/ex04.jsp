<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2중 forEach</title>
</head>
<body>
	<%-- <c:forEach var="i" begin="3" end="5"> --%>
	<c:forEach var="i" begin="${param.start}" end="${param.end}">	<!-- url뒤 ?start=3&end=5 이렇게 붙여줘도 OK -->
		<h2>${i}단</h2>
		<c:forEach var="j" begin="1" end="9">
			${i} x ${j} = ${i*j}<br>
		</c:forEach>
	</c:forEach>
</body>
</html>