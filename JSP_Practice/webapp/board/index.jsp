<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
</head>
<body>
	<c:redirect url="/board_servlet/list.do" />
	<%-- <% response.sendRedirect("/jsp02/board_servlet/list.do"); %>	위와 같은 코드 --%>
</body>
</html>