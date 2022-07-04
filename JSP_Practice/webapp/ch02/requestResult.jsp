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
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String gender = request.getParameter("gender");
	String hobby = request.getParameter("hobby");
	%>
	<ul>
		<li> 이름 : <%=name%> </li>
		<li> 나이 : <%=age%> </li>
		<li> 성별 : <%=gender%> </li>
		<li> 취미 : <%=hobby%> </li>
	</ul>
</body>
</html>