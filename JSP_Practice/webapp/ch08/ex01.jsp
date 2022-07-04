<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL(Expression Language) : jsp에서 자바코드를 대체할 수 있음</title>
</head>
<body>
	${2 + 2}<br>
	${4 / 2}<br>
	${7 mod 2}<br>		<!-- mod : 나머지 -->
	${2 < 3}<br>		
	${3 le 4}<br>		<!-- le : 작거나 같다 -->
	${(5>3) ? 5:3}<br>	<!-- 조건? true:false -->
</body>
</html>