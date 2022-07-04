<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String id = request.getParameter("id");		// 아이디	
	String pwd = request.getParameter("pwd");	// 비번
	MemberDAO dao = new MemberDAO();
	MemberDTO dto = new MemberDTO();
	dto.setUserid(id);
	dto.setPasswd(pwd);
	String result = dao.login(dto);
	if(result != null) {						// 로그인 성공 시
		out.println(result + "님 반갑습니다.");
	} else {									// 로그인 실패 시
		out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
	}
	%>
</body>
</html>