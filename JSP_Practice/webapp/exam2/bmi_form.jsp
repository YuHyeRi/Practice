<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- <form method="post" action="/jsp02/bmi_servlet/bmi.do"> -->
	<form method="post" action="bmi_result.jsp">
		이름		<input name="name"><br>
		키(cm)	<input name="height" type="number"><br>
		체중(kg)	<input name="weight" type="number"><br>
		<input type="submit" value="계산"><br>
	</form>
</body>
</html>