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
	String name = request.getParameter("name");
	String job = request.getParameter("job");
	int sal = Integer.parseInt(request.getParameter("sal"));
	double bonus = 0;
	if(job.equals("사원")) {
		bonus = sal*2;
	} else if(job.equals("주임")) {
		bonus = sal*2.5;
	} else if(job.equals("과장")) {
		bonus = sal*3;
	} else if(job.equals("부장")) {
		bonus = sal*4;
	}
	double total = sal*12 + bonus;
	int tax = (int)(total * 0.03);
	double total_Sal = total-tax;
	%>
	이름 : <%=name%><br>
	직급 : <%=job%><br>
	기본급 : <%=String.format("%,d", sal)%>원<br>
	보너스 : <%=String.format("%,10.0f", bonus)%>원<br>		<!-- 소수점이하 1자리수까지만 출력 -->
	총액 : <%=String.format("%,10.0f", total)%>원<br>
	세액 : <%=String.format("%,d", tax)%>원<br>
	실수령액 : <%=String.format("%,10.0f", total_Sal)%>원<br>
</body>
</html>