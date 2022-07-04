<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(function() {
		$("#btnSave").click(function() {
			var writer = $("#writer").val();	// id가 writer인 태그에 입력한 값
			var subject = $("#subject").val();
			var content = $("#content").val();
			var passwd = $("#passwd").val();
			
			if(writer == ""){
				alert("이름을 입력하세요.");
				$("#writer").focus();			// focus : 입력 커서 이동
				return;
			}
			if(subject == ""){
				alert("제목을 입력하세요.");
				$("#subject").focus();
				return;
			}
			if(content == ""){
				alert("내용을 입력하세요.");
				$("#content").focus();
				return;
			}
			if(passwd == ""){
				alert("비밀번호를 입력하세요.");
				$("#passwd").focus();
				return;
			}
			var filename = form1.file1.value;	// 첨부파일 이름
			var start = filename.lastIndexOf(".") + 1;
			if(start != -1){					// 마침표가 있으면
				var ext = filename.substring(start, filename.length);
				if(ext == "jsp" || ext == "exe") {
					alert("업로드할 수 없는 파일 입니다.");
					return;
				}
			}
			document.form1.submit();
		});
	});
</script>
</head>
<body>
	<c:if test="${param.message == 'error'}">
		<script>
			alert("업로드할 수 없는 파일입니다.");
		</script>
	</c:if>
	
	<h2>글쓰기</h2>
	<!-- ★★★ enctype : 파일업로드에 꼭 필요한 속성!! -->
	<form name="form1" method="post" action="/jsp02/board_servlet/insert.do" enctype="multipart/form-data" >
	<table border="1" width="700px">
		<tr>
			<td align="center">이름</td>
			<td><input name="writer" id="writer"></td>
		</tr>
		<tr>
			<td align="center">제목</td>
			<td><input name="subject" id="subject" size="60"></td>
 		</tr>
		<tr>
			<td align="center">본문</td>
			<td><textarea rows="5" cols="60" name="content" id="content"></textarea></td>
 		</tr>
 		<tr>
			<td align="center">첨부파일</td>
			<td><input type="file" name="file1"></td>
		</tr>
		<tr>
			<td align="center">비밀번호</td>
			<td><input type="password" name="passwd" id="passwd"></td>
 		</tr>
 		<tr>
			<td colspan="2" align="center">
 			<input type="button" value="확인" id="btnSave"></td>
		</tr>
	</table>
</body>
</html>