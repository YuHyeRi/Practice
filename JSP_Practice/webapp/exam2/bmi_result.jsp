<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body {font-size : 2rem;}
</style>
</head>
<body>
	<%
	String name = request.getParameter("name");
	int height = Integer.parseInt(request.getParameter("height"));
	double m = height/100.0;
	int weight = Integer.parseInt(request.getParameter("weight"));
	double bmi = weight / (m*m);
	
	String grade ="";
	if(bmi<=18.5){
		grade = "저체중";
	} else if(bmi>=18.5 && bmi<23) {
		grade = "정상";
	}else if(bmi>=23 && bmi<25) {
		grade = "과체중";
	}else if(bmi>=25 && bmi<30) {
		grade = "비만";
	}else if(bmi>=30) {
		grade = "고도비만";
	}
	%>
	
	이름 : <%=name%><br>
	신장 : <%=height%><br>
	몸무게 : <%=weight%><br>
	bmi : <%=bmi%><br>
	결과 : <%=grade%>
</body>
</html>