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
	int dan = Integer.parseInt(request.getParameter("dan"));
	for(int i=1; i<10; i++){
		out.println(dan + " X " + i + " = " + dan*i + "<br>");	// <br> 넣는거 잘 보기!
	}
	%>
</body>
</html>