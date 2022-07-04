<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/script/jquery/jquery-1.12.4.min.js"></script>
<script>
	$(document).ready(function() {
		$("#listBtn").on("click", function() {
			$("#actionForm").attr("action", "testList");
			$("#actionForm").submit();
		});
		
		$("#updateBtn").on("click", function() {
			$("#actionForm").attr("action", "testUpdate");		/* testUpdate가 새로 생겼으니 controller */
			$("#actionForm").submit();
		});
		
		$("#deleteBtn").on("click", function() {
			if(confirm("정말 삭제하시겠습니까?")) {
				$("#actionForm").attr("action", "testDelete");	/* testDelete가 새로 생겼으니 controller */
				$("#actionForm").submit();
			}
		});
	});	// document ready end
</script>
</head>
<body>
	<form action="#" id="actionForm" method="post">							<!-- 그걸 form으로 -->
		<input type="hidden" name="no" value="${param.no}"	/>
		<input type="hidden" name="searchGbn" value="${param.searchGbn}"/>	<!-- searchGbn을 hidden으로 가짐 -->
		<input type="hidden" name="searchTxt" value="${param.searchTxt}" />	<!-- searchTxt을 hidden으로 가짐 -->
		<input type="hidden" name="page" value="${param.page}" />			<!-- 넘어오는 값 이니까 param -->
	</form>
	- 번호 : ${data.NO}<br>
	- 제목 : ${data.TITLE}<br>
	- 작성자 : ${data.WRITER}<br>
	- 작성일 : ${data.DT}<br>
	- 내용 : ${data.CONTENT}<br>
	<input type="button" id="listBtn" value="목록으로" />
	<input type="button" id="updateBtn" value="수정" />
	<input type="button" id="deleteBtn" value="삭제" />
</body>
</html>