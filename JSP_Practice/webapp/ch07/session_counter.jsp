<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 카운터</title>
</head>
<body>
	<%
	Integer countNum = (Integer)session.getAttribute("counter");	// counter란 이름의 세션변수를 조회
	int num = 1;
	if(countNum == null) {		// 값이 null이면 => 첫방문이면
		countNum = 1;			// countNum을 1로 초기화
	} else {					// 첫방문이 아닐때 => 재방문이면
		num = countNum.intValue();	// countNum가 integer니까 .intValue()
		num++;
		countNum = num;
	}
	session.setAttribute("counter", countNum);
	%>
	<h2><%=countNum.intValue()%>번째 방문입니다.</h2><br>
	<%
		String counter = Integer.toString(num);		// int -> String
		for(int i=0; i<counter.length(); i++) {
			String img= "<img src='../images/" + counter.charAt(i) + ".gif'>";
			out.println(img);
		}
	%>
</body>
</html>