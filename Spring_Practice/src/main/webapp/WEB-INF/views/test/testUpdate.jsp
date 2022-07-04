<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>testAdd.jsp 복붙 후 수정</title>
<script type="text/javascript" src="resources/script/jquery/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#cancelBtn").on("click", function() {
			history.back();
		});
		
		$("#updateBtn").on("click", function() {	
			if(checkVal("#title")) {
				alert("제목을 입력하세요.");
				$("#title").focus();
			} else if(checkVal("#writer")) {
				alert("작성자를 입력하세요.");
				$("#writer").focus();
			} else if(checkVal("#content")) {
				alert("내용 입력하세요.");
				$("#content").focus();
			} else {
				$("#updateForm").submit();			
			}	
		});
	});	//document ready end
	
	function checkVal(sel) {
		if($.trim($(sel).val()) == "") {
			return true;
		} else {
			return false;
		}
	}
</script>
</head>
<body>
	<!-- testUpdates라는 새로운 주소가 생겼으니 controller -->
	<form action="testUpdates" id="updateForm" method="post">
		<input type="hidden" name="searchGbn" value="${param.searchGbn}"/>
		<input type="hidden" name="searchTxt" value="${param.searchTxt}" />
		<input type="hidden" name="page" value="${param.page}" />
		<input type="hidden" name="no" value="${data.NO}" />	<!-- 추가데이터 : 값넘기기 용도라 사용자한테 보여지지 X -->
		번호 : ${data.NO}<br>										<!-- 추가데이터 -->
		제목 <input type="text" id="title" name="title" value="${data.TITLE}"/><br>			<!-- value 추가 -->
		작성자 <input type="text" id="writer" name="writer" value="${data.WRITER}"/><br>		<!-- value 추가 -->
		내용<br>
		<textarea rows="8" cols="40" id="content" name="content">${data.CONTENT}</textarea>	<!-- 추가데이터 -->
	</form>
	<input type="button" value="수정"	 id="updateBtn" />
	<input type="button" value="취소"	 id="cancelBtn" />
</body>
</html>