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
	String birth = request.getParameter("birth");
	
	int birth2 = 2021- (Integer.parseInt(birth));
	
	%>
	
	<%=name%>님의 나이는 만<%=birth2%>살 입니다!

</body>
</html>