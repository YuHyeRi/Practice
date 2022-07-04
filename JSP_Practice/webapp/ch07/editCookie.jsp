<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>4. 쿠키수정</title>
</head>
<body>
	<%												// 쿠키 수정함수도 없음 (쿠키는 only add함수뿐)
	response.addCookie(new Cookie("id", "이진우"));	// 기존값이 덮어쓰기 됨
	response.addCookie(new Cookie("pwd", "5678"));
	%>
	아이디 : ${cookie.id.value};<br>
	쿠키가 변경 되었습니다.<br>
	<a href="useCookie.jsp">쿠키확인</a>
</body>
</html>