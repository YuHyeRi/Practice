<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String color = request.getParameter("color");
	String selectColor = "";
	
	if(color.equals("red")) {
		selectColor = "빨강";
	} else if(color.equals("salmon")) {
		selectColor = "피치";
	} else if(color.equals("green")) {
		selectColor = "초록";
	} else if(color.equals("blue")) {
		selectColor = "파랑";
	} %>
	<%= name %> 님이 선택한 색상은 <%= selectColor %> 입니다<br><br>
	<div style = "background : <%=color%>; width:200px; height:200px"></div>
	
</body>
</html>