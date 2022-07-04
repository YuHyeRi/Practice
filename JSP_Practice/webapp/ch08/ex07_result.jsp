<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.MemberDTO" %> <!-- 자바코드 출력시 import가 필요함 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	out.println("<h2>" + "java출력" + "</h2>");
	MemberDTO dto = (MemberDTO)request.getAttribute("dto");
	if(dto != null) {
		out.println("이름 : " + dto.getName() + "<br>");
		out.println("아이디 : " + dto.getUserid() + "<br>");
		out.println("비번 : " + dto.getPasswd() + "<br>");
	} else {
		out.println("출력할 값이 없습니다.");
	}
	%>
	<h2> EL 방식</h2>
	이름 : ${dto.name}<br>			<!-- {참조변수명.세부변수명} -->
	아이디 : ${dto.userid}<br>
	비밀번호 : ${dto.passwd}<br>
</body>
</html>