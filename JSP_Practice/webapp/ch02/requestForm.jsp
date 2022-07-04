<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!-- <form method="post" action="requestResult.jsp"> -->
	<form method="post" action="/jsp01/ch02_servlet/request.do">	<!--이 주소와 Controller 주소일치 (jsp 제외)-->
	이름 <input type="text" name="name"><br>
	나이 <input type="number" name="age" min="20" max="100"><br>
	성별 <input type="radio" name="gender" value="남성" checked>남
		<input type="radio" name="gender" value="여성">여<br>
	취미 <select name="hobby">
		<option value="운동" checked>운동</option>
		<option value="요리">요리</option>
		<option value="독서">독서</option>
		<option value="등산">등산</option><br>
	</select>
	<input type="submit" value="확인">	
	</form>
	
</body>
</html>