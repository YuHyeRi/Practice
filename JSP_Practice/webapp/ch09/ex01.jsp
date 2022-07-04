<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	/* header 정보 */
	Enumeration<String> headerNames = request.getHeaderNames();
	while(headerNames.hasMoreElements()) {						// 다음 요소가 있다면 true
		String key = (String)headerNames.nextElement();			// 다음 요소 읽음
		String value = request.getHeader(key);					// 변수 value에 key 값을 담음
		out.println(key + " : " + value + "<br>");
	}
	%>
	<hr>
	<%-- <c:forEach> : 배열요소를 순서대로 반복해서 처리함 --%>
	<c:forEach var="h" items="${header}">
		${h.key} ==> ${h.value}<br>
	</c:forEach>
	
	<hr>
	<%-- out은 생략 가능, browser : ${browser} --%>
	<c:set var="browser" value="${header['user-agent']}" />
	browser : <c:out value="${browser}" /> 
	<hr>
	
	<%-- <c:remove> : 변수제거 --%>
	<c:remove var="browser" />	
	browser : <c:out value="${browser}" />
</body>
</html>