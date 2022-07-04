<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>		
	<!-- 
	** 컨텍스트패스 : 웹프로젝트의 식별자,
	** request.getContextPath() : 컨텍스트패스를 구하는 함수
	** 서블릿 : 서버에서 실행되는 코드
	** 보통 jsp에서 jsp로 보내지 않고, "jsp -> servlet -> jsp" 형식으로 한다 
	-->
	<br>
	<form method = "post" action = "<%=request.getContextPath()%>/ch01_servlet/while.do">
	곱해질 값 : <input name = "number"><br>
	곱해질 횟수 : <input name = "num"><br>
	<input type = "submit" value = "확인">
	</form>
</body>
</html>