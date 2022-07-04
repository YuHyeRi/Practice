<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션저장</title>
</head>
<body>
<%-- 
session.setAttribute(key,value) : 세션변수 저장
session.getAttribute(key) : 세션변수 조회
	${sessionScope.key}
session.invalidate() : 세션 전체 초기화 
--%>
	<%
	String id = "Kim@nate.com";
	String passwd = "1234";
	int age = 20;
	double height = 170.5;
	
	// session : 내장객체 => 별다른 선언 없이 바로 사용 가능
	// session : 보안면에서 쿠키보다 우수하다
	// session : 사용자가 로그인해서 로그아웃할때까지, 모든페이지에서 사용 가능
	session.setAttribute("id",id);	// key(변수명), value(session은 모든 자료형 가능)
	session.setAttribute("passwd",passwd);
	session.setAttribute("age",age);
	session.setAttribute("height",height);
	out.println("세션값 저장완료!" + "<br>");
	%>
	<h2><a href="viewSession.jsp">세션확인</a></h2>
</body>
</html>