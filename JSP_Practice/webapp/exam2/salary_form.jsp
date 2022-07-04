<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body {
		font-size : 1.5rem;
	}
</style>
</head>
<body>
	<h2>연봉계산기</h2>
	<form method="post" action="salary_result.jsp">
	이름 <input name="name"><br>
	직급 <input name="job"><br>
	기본급 <input type="number" name="sal"><br>
	보너스 <input type="number" name="bonus">
	<input type="submit" value="계산">
	</form>
</body>
</html>