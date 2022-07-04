<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 세션 부르는 방법 1 -->
	이름1 : <%=session.getAttribute("name")%><br>
	나이1 : <%=session.getAttribute("age") %><br>
	
	<!-- 세션 부르는 방법 2 -->
	<%-- ${sessionScope.변수} : 자바코드 session.getAttribute("변수")를 대체하는 코드 --%>
	이름2 : ${sessionScope.name}<br>
	나이2 : ${sessionScope.age}<br>
</body>
</html>