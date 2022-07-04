<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form method="post" action="/jsp01/ch02_servlet/login.do">
	아이디 <input type="text" name="id"><br>
	패스워드 <input type="password" name="pw">
	<input type="submit" value="로그인">	
	</form>
	
	<span style="color:salmon;">${param.message}</span>
	
</body>
</html>