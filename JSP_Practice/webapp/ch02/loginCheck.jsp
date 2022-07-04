<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userid = (String)session.getAttribute("userid");
	if(userid == null) { %>
<script>
	alert("로그인 후 사용 가능합니다.");
	location.href = "login.jsp";
</script>
<% 
} %>
