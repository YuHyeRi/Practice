<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp"%>	<!-- 방법2를 쓰기 위해 import -->
</head>
<body>
	<!-- 자바방법 -->
	<!-- session변수에 값 셋팅 : 모든 자료형 가능 -->
	<%
	session.setAttribute("name", "sean");
	session.setAttribute("age", 30);
	session.setAttribute("job", "배우");
	%>
	
	<!-- EL방법 -->
	<!-- var변수에 저장 :  var변수명, value값, scope사용범위 -->
	<c:set var="name" value="송강" scope="session" />
	<c:set var="age" value="30" scope="session" />
	<c:set var="job" value="배우" scope="session" />
	<h3>생성변수 생성완료</h3>
	<a href="ex04_result.jsp">클릭</a>
</body>
</html>