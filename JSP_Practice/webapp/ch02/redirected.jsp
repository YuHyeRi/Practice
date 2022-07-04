<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>이동된 페이지</h2>
	<%-- <%
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	%>
	이름 <%=name%>, 나이 <%=age%> --%>
	이름 ${param.name}, 나이${param.age}	<%-- ${param.변수} : 자바코드 request.getParameter("변수")를 대체하는 코드 --%>
										<%-- ${변수} : 자바코드 request.getAttribute("변수")를 대체하는 코드 --%>
</body>
</html>