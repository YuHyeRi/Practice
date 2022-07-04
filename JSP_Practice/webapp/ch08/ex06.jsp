<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.HashMap" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	/* HashMap : 자료를 빨리 찾기 위함 (순서X) */
	HashMap<String,String> h = new HashMap<String,String>();
	h.put("포도", "a");
	h.put("체리", "b");
	h.put("딸기", "c");
	h.put("복숭아", "d");
	request.setAttribute("h", h);
	%>
	<jsp:forward page="ex06_result.jsp" />
</body>
</html>