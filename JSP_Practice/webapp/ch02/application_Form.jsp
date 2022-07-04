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
	String info = application.getServerInfo();	// 웹 서버의 정보
	application.log("WAS정보 : " + info);			// 콘솔에 로그 출력
	
	String path = application.getRealPath("/");	// 실제 서비스 경로
	application.log("서비스정보 : " + path);
	application.setAttribute("message", "hello");	// application 영역에 변수 저장
	%>
	<a href = "application_Result.jsp">서버 변수 확인</a>
</body>
</html>