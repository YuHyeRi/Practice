<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function view(userid){
		// document html문서를 가리키는 객체, form1 태그 내부의 userid 태그에 입력한 값
		document.form1.userid.value = userid;
		document.form1.submit();		// 폼에 입력한 데이터를 서버에 전송
	}
</script>
</head>
<body>
	<table border="1">
		<tr>
			<th>이름</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>가입일자</th>
			<th>주소</th>
			<th>전화</th>
		</tr>
	<c:forEach var="row" items="${map.list}">
		<tr>
			<td><a href="#" onclick="view('${row.userid}')">${row.name}</a></td>
			<td>${row.userid}</td>
			<td>${row.passwd}</td>
			<td>${row.reg_date}</td>
			<td>${row.address}</td>
			<td>${row.tel}</td>
		</tr>
	</c:forEach>
	</table>
	<form name="form1" method="post" action="/jsp02/member_servlet/view.do">
	<input type="hidden" name="userid">
	</form>
</body>
</html>