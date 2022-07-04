<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2. 쿠키사용</title>
</head>
<body>
	<%
	Cookie[] cookies = request.getCookies();		// 쿠키는 배열로 저장됨 (때문에 출력할때 순서가 랜덤하게 출력됨)
	if(cookies != null) {
		for(int i=0; i<cookies.length; i++) {
			out.println("쿠키이름1 : " + cookies[i].getName() + "<br>");	// getName : 변수명
			out.println("쿠키값1 : " + cookies[i].getValue() + "<br>");	// getValue : 값
		}
	}
	%>
	<!-- EL 표현언어를 사용한다면, 아래처럼 간단히 사용도 가능 -->
	아이디 : ${cookie.id.name} ${cookie.id.value}<br>
	비밀번호 : ${cookie.pwd.name} ${cookie.pwd.value}<br>
	이름 : ${param.name}<br>		<!-- param : 'request.getParameter("변수")'를 대체하는.. -->
	<a href="deleteCookie.jsp?name=${param.name}">쿠키삭제</a><br>
	<a href="editCookie.jsp">쿠키수정</a>
</body>
</html>