<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>3. 쿠키삭제</title>
</head>
<body>
	<%										// 쿠키는 삭제함수가 없어서 빈값으로 만든 후, 즉시 지워서 없앰
	Cookie cookie = new Cookie("id","");	// 쿠키값을 빈값으로 하나 만듦
	cookie.setMaxAge(0);					// 유효시간:0초라는 것은 즉시 지워짐
	response.addCookie(cookie);				// 쿠키는 삭제함수가 없음
	
	Cookie cookie2 = new Cookie("pwd","");	// 비밀번호도 지우고 싶다면, 똑같이 다시 만들어서..
	cookie.setMaxAge(0);					
	response.addCookie(cookie);
	%>
	쿠키가 삭제되었습니다.
	<a href="useCookie.jsp">쿠키확인</a>
</body>
</html>