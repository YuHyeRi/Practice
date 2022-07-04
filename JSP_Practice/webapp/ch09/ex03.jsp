<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- core태그 쓰려고 불러옴 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Scope : 현재페이지만, 다음페이지까지, 사용자별, 서버단위 -->
	<c:set var="num" value="<%=new Integer(100)%>" scope="page" />	<!-- Integer로 변환 -->
	<c:set var="num" value="200" scope="request" />					<!-- 디폴트값은 String -->
	<c:set var="num" value="300" scope="session" />
	<c:set var="num" value="400" scope="application" />
	<!-- 위 변수 출력 -->
	${num}<br>
	${pageScope.num}<br>
	${requestScope.num}<br>
	${sessionScope.num}<br>
	${applicationScope.num}<br>
	<hr>
	
	<c:if test="${num > 10}">
	${num} > 10
	</c:if>
	<hr>
	
	<%
	int num = (Integer)pageContext.getAttribute("num");
	if(num > 10) {
		out.println("java로 출력한 num 값 : " + num + "<br>");
	}
	pageContext.setAttribute("num", 100);
	request.setAttribute("num", 200);
	session.setAttribute("num", 300);
	application.setAttribute("num", 400);
	
	out.println(pageContext.getAttribute("num"));
	out.println(request.getAttribute("num" ));
	out.println(session.getAttribute("num"));
	out.println(application.getAttribute("num"));
	%>
</body>
</html>