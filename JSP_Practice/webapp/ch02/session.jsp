<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// session 객체 : 사용자의 정보를 로그아웃 할 때까지 저장, 모든 페이지에 정보가 유지됨, 서버 무거워지니 필요할 경우만
		//			    세션영역에 변수저장, 모든 페이지에서 사용가능
		
		session.setAttribute("name", "아이유");
		session.setAttribute("age", 28);
		
		// request 객체 : 다음페이지까지만 정보가 유지됨
		// request.setAttribute("name", "아이유2");
		// request.setAttribute("age", 30);
	%>
	<jsp:forward page="sessionResult.jsp"/>	<!-- jsp 액션태그 : 지정된 페이지로 포워드 (==> 요즘 잘 쓰지 않음) -->
</body>
</html>