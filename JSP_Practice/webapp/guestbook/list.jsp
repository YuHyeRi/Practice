<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp"%>
<script type="text/javascript">
	function gb_search() {
		document.form1.action = "/jsp02/guestbook_servlet/list.do";
		document.form1.submit();
	}
</script>
</head>
<body>
	<h2>방명록</h2>
	<form name="form1" method="post">
		<select name="searchkey">
			<c:if test="${searchkey == 'name'}">
				<option value="name" selected="selected">이름</option>
				<option value="content">내용</option>
				<option value="name_content">이름+내용</option>
			</c:if>
			<c:if test="${searchkey == 'content' }">
				<option value="name">이름</option>
				<option value="content" selected="selected">내용</option>
				<option value="name_content">이름+내용</option>
			</c:if>
			<c:if test="${searchkey == 'name_content' }">
				<option value="name">이름</option>
				<option value="content" >내용</option>
				<option value="name_content" selected="selected">이름+내용</option>
			</c:if>
		</select>
		<input type="text" name="search" value="${search}" >
		<input type="button" value="조회" onclick="gb_search()" >
	</form>
	
	${count}개의 글이 있습니다.&nbsp;
	<input type="button" value="글쓰기" onclick="location.href='/jsp02/guestbook/write.jsp'" >
	<c:forEach var="dto" items="${list}">
	<form action="/jsp02/guestbook_servlet/passwd_check.do" method="post">
		<input type="hidden" name="idx" value="${dto.idx}" >
		<table border="1" style="width:600px">
		<tr>
			<td style="text-align:center; background-color:salmon; width:20%">이름</td>
			<td style="text-align:center; background-color:salmon; width:30%">${dto.name}</td>
			<td style="text-align:center; background-color:salmon; width:20%">날짜</td>
			<td style="text-align:center; background-color:salmon; width:30%">${dto.post_date}</td>
		</tr>
		<tr>
			<td style="text-align:center; background-color:salmon">이메일</td>
			<td colspan="3">${dto.email}</td>
		</tr>
		<tr>
			<td colspan="4">${dto.content}</td>
		</tr>
		<tr>
			<td colspan="4">
			비밀번호
			<input type="password" name="passwd" >
			<input type="submit" value="수정/삭제" >
			</td>
		</tr>
		</table>
	</form>
	</c:forEach>
</body>
</html>