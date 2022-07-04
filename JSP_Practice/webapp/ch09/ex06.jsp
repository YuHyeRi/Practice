<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	*********************Date 함수<br>
	<%
	Date d = new Date();
	out.println("1. " + d + "<br>");
	%>
	<c:set var="d" value="<%=new Date()%>" />
	2. ${d}<br>
	<hr>
	*********************날짜 출력<br>
	<fmt:formatDate value="${d}"/><br>
	<fmt:formatDate value="${d}" type="date" /><br>
	<hr>
	*********************시간 출력<br>
	<fmt:formatDate value="${d}" type="time" /><br>
	<hr>
	*********************패턴을 사용할 경우<br>
	<fmt:formatDate value="${d}" pattern="yyyy-MM-dd HH:mm:ss" /><br>
	<fmt:formatDate value="${d}" dateStyle="full" /><br>
	<fmt:formatDate value="${d}" dateStyle="long" /><br>
	<fmt:formatDate value="${d}" dateStyle="medium" /><br>
	<fmt:formatDate value="${d}" dateStyle="short" /><br>
	<hr>
	*********************천단위콤마<br>
	<c:set var="num" value="99999999" />
	${num}<br>
	<fmt:formatNumber value="${num}" groupingUsed="true" /><br>	<!-- groupingUsed="true" : 1000단위마다 콤마 -->
	<fmt:formatNumber value="${num}" pattern="#,###.##" /><br>
	<fmt:formatNumber value="${num}" pattern="#,###.00" /><br>	<!-- .00을 쓰면 값이 없어도 00으로 자리를 채움 -->
</body>
</html>