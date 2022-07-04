<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="emp.dao.EmpDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	EmpDAO dao = new EmpDAO();		/* 실행시간 : 11014 (밀리세컨드, 약11초정도) */
	dao.insert();					/* 실행시간 : 137 (1초도 안되어서 끝남)*/
	dao.insert_batch();
	out.println("작업완료");
	%>
</body>
</html>