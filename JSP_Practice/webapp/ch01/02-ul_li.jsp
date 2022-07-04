<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% String[] str = {"jsp", "java", "sql", "spring"}; %>
	<!-- String[] str = null, null을 쓰면 Error!! 흔히 하는 실수, 주의하자! -->
	<ul>
	<% for(String s : str) { %>
	<li> <%= s %> </li>
	<% } %>
	</ul>

</body>
</html>