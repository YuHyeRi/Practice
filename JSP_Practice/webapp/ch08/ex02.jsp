<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form metod="get">	<!-- **action이 없다면 현재페이지에 값을 전달함 -->
		1. 이름 : <input name="name" value="${param.name}"><br>					<!-- 빈칸을 공백으로 표시 -->
		2. 이름 : <input name="name" value="<%=request.getParameter("name")%>">	<!-- 빈칸을 null로 표시 -->
		<input type="submit" value="확인">
	</form>
	<hr>
	1. ${param.name}<br>					<!-- 빈칸을 공백으로 표시 -->
	2. <%=request.getParameter("name")%>	<!-- 빈칸을 null로 표시 -->
</body>
</html>