<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1. 쿠키생성</title>
</head>
<body>
	<%
	Cookie cookie = new Cookie("id", "유혜리");	// key, value
	Cookie cookie2 = new Cookie("pwd", "1234");	// value는 String 이니까 "" 붙여주기
	cookie.setMaxAge(10);				// 쿠키의 유효시간, 10초후에 삭제됨(초단위)
	response.addCookie(cookie);			// 쿠키저장, 사용자의 pc에 쿠키 생성
	response.addCookie(cookie2);		// 쿠키저장
	%>
	쿠키가 생성 되었습니다.<br>
	<a href="useCookie.jsp?name=김철수">쿠키확인</a>
</body>
</html>