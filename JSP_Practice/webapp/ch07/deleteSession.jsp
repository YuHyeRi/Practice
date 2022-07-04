<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션삭제</title>
</head>
<body>
	<%
	//session.invalidate();					// 세션 전체 삭제시 ==> 세션확인 누르면 Error뜨는게 맞다. null값인데 형변환 하라고 하니까
	 session.removeAttribute("id");			// 개별 삭제시
	// session.removeAttribute("passwd");
	// session.removeAttribute("age");
	// session.removeAttribute("height");
	%>
	<h3>세션이 초기화 되었습니다.</h3>
	<a href="viewSession.jsp">세션확인</a>
</body>
</html>