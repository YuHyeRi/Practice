<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp"%>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#btnUpdate").click(function() {
			var writer = $("#writer");		/* 쉽게 쓰게 그냥 변수로 설정해둠 */
			var memo = $("#memo");
			if(writer.val() == "") {		/* 빈값이면 */
				alert("이름을 입력하세요.");		/* 경고창 띄우기 */
				writer.focus();				/* 입력 포커스 설정 */
				return;						/* 함수 종료 */
			}
			if(memo.val() == "") {
				alert("메모를 입력하세요.");
				memo.focus();
				return;
			}
			/* 데이터를 받을 주소 지정 */
			document.form1.action = "/jsp02/memo_servlet/update.do";	/* name이 form1인 태그의 액션 */
			document.form1.submit();									/* 폼 데이터 제출 */
		});
		$("#btnDelete").click(function() {
			if(confirm("삭제하시겠습니까?")) {
				document.form1.action = "/jsp02/memo_servlet/del.do";
				document.form1.submit();
			}
		});
	});
</script>
</head>
<body>
	 <h2>메모 수정</h2>
	 <form name="form1" method="post">
 		<table border="1" style="width: 550px">
 		<tr>
 			<td>이름</td>
 			<td><input type="text" name="writer" id="writer" value="${dto.writer}"></td>
 		</tr>
 		<tr>
 			<td>메모</td>
			<td><input type="text" name="memo" id="memo" size="60" value="${dto.memo}"></td>
		</tr>
		<tr align="center">
 			<td colspan="2">	<!-- 가로 셀 합치기 -->
 			<input type="hidden" name="idx" value="${dto.idx}">
 			<input type="button" value="수정" id="btnUpdate">
 			<input type="button" value="삭제" id="btnDelete">
 			</td>
 		</tr>
 		</table>
 	</form>
</body>
</html>