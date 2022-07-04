<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.HashMap" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
</head>
<body>
	<%
	HashMap<String,String> h = (HashMap<String,String>)request.getAttribute("h");
	String[] fruits = {"딸기", "체리", "포도", "복숭아"};
	for(String str : fruits) {
		out.println(str + " : " + h.get(str) + "<br>");}
	%>
	${h["딸기"]}<br>
	${h["체리"]}<br>
	${h["포도"]}<br>
	${h["복숭아"]}<br>
	<c:forEach var="row" items="${h}">
		${row} : ${row.key} =====> ${row.value}<br>
	</c:forEach>
</body>
</html>