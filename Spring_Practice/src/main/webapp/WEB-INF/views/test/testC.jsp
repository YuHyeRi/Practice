<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="resources/css/testC.css"/>
</head>
<body>
	<!-- 참고로 코어태그 안의 주석은 !가 아니라 %로 써주어야 함! -->
	<c:import url="/testTopLeft">
		<c:param name="msg">보낸 메세지</c:param>
	</c:import>
	<div class="con">con</div>
</body>
</html>