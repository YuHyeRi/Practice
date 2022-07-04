<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="country" value="korea" />			<!-- var:변수명, value:값 -->
	<c:if test="${country != null}">				<!-- country가 null이 아니면 -->
		국가명1 : <c:out value="${country}" /><br>
		국가명2 : ${country}<br>
	</c:if>
	<hr>
	
	<%
	int[] nums = {10,20,30,40,50,70,80};
	%>
	<c:set var="num" value="<%=nums%>" />			<!-- 위 배열값을 가진 num변수 생성 -->
	<c:forEach var="n" items="${num}">				<!-- var:개별값, items:집합 -->
		${n},
	</c:forEach>
	<hr>
	
	<c:set var="season" value="겨울" />
	<c:choose>
		<c:when test="${season == '봄'}">
			<img src="${pageContext.request.contextPath}/images/spring.jpg">
		</c:when>
		<c:when test="${season == '여름'}">
			<img src="${pageContext.request.contextPath}/images/summer.jpg">
		</c:when>
		<c:when test="${season == '가을'}">
			<img src="${pageContext.request.contextPath}/images/autumn.jpg">
		</c:when>
		<c:when test="${season == '겨울'}">
			<img src="${pageContext.request.contextPath}/images/winter.jpg">
		</c:when>
		<c:otherwise>다른 경우 모두..</c:otherwise>
	</c:choose>
</body>
</html>