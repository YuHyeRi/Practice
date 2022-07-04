<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- <form method="post" action="ageResult.jsp"> -->
	<form method="post" action="/jsp01/age_servlet/age.do">
	이름 <input name = "name"><br>
	출생연도 <input type ="number" name="birth" min="1900" max="2021"><br>
	<input type="submit" value="확인">
	</form>

</body>
</html>