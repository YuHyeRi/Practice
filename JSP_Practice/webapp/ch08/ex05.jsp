<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
</head>
<body>
	<%
	/* ArrayList<모든자료형> */
	ArrayList<String> s = new ArrayList<String>();
	s.add("apple");
	s.add("strawberry");
	s.add("cheery");
	s.add("peach");
	request.setAttribute("s",s);			/* add한 값들을 request 객체에 저장 */
	%>
	<jsp:forward page="ex05_result.jsp" />	<!-- jsp 액션태그를 이용해 forward시킴 -->
</body>
</html>