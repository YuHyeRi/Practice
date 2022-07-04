<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <style>
	body {font-size : 2rem;}
</style> -->
</head>
<body>
	<%
	/* 폼데이터 - 스트링 */
	/* Integer.parseInt(String) : String에서 숫자 추출 "5" -> 5 */
	int dan=Integer.parseInt(request.getParameter("dan"));
	out.println(dan + "단" + "<br>");
	for(int i=1; i<10; i++) {
		out.println(dan + " x " + i + " = " + dan*i + "<br>");
	}
	%>
</body>
</html>