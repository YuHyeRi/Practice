<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body {
		font-size : 1.5rem;
	}
</style>
</head>
<body>
	<%
	String name = request.getParameter("name");
	String job = request.getParameter("job");
	int sal = Integer.parseInt(request.getParameter("sal"));
	int bonus = Integer.parseInt(request.getParameter("bonus"));
	int total = (sal*12) + bonus;
	int tax = (int)(total*0.3);
	int total_Sal = total-tax;
	%>
	이름 : <%=name%><br>
	직급 : <%=job%><br>
	기본급 : <%=String.format("%,d", sal)%>원<br>
	보너스 : <%=String.format("%,d", bonus)%>원<br>
	총액 : <%=String.format("%,d", total)%>원<br>
	세액 : <%=String.format("%,d", tax)%>원<br>
	실수령액 : <%=String.format("%,d", total_Sal)%>원<br>
</body>
</html>