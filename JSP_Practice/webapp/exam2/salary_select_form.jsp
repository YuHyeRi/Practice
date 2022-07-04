<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>연봉 계산기</h2>
	<form method="post" action="salary_select_result.jsp">
	이름 <input name="name">
	<br>
	직급 <select name="job">
			<option value="사원">사원</option>
			<option value="주임">주임</option>
			<option value="과장">과장</option>
			<option value="부장">부장</option>
	</select>
	<br>
	기본급 <input type="number" name="sal">
	<input type="submit" value="계산하기">
	</form>
</body>
</html>