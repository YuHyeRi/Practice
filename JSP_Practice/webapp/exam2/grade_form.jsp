<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>성적계산 프로그램</h2>
	<p><b>처리조건</b><br>
	총점 = 국어점수 + 영어점수 + 수학점수<br>
	평균 = 총점 / 3 (소수 무시, 정수만 표시)<br>
	등급 : A(90~100점), B(80~89점), C(70~79점), D(60~69점), F(60점 미만)</p>
	<form method="post" action="grade_result.jsp">
	이름 <input name="name"><br>
	국어 <input name="kor"><br>
	영어 <input name="eng"><br>
	수학 <input name="mat">
	<input type="submit" value="확인">	
	</form>
</body>
</html>