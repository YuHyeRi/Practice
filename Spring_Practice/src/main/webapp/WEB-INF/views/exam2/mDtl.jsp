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
			$("#actionForm").attr("action","mList");
			$("#actionForm").submit();
		});
		
		$("#updateBtn").on("click", function() {
			$("#actionForm").attr("action","mUpdate");		
			$("#actionForm").submit();
		});
		
		$("#deleteBtn").on("click", function() {
			if(confirm("정말 삭제하시겠습니까?")) {
				$("#actionForm").attr("action","mDelete");	
				$("#actionForm").submit();
			}
		});
	});	// doc end
</script>
</head>
<body>
	<form action="#" id="actionForm" method="post">							
		<input type="hidden" name="M_NO" value="${param.M_NO}"	/>
		<input type="hidden" name="searchGbn" value="${param.searchGbn}"	/>	
		<input type="hidden" name="searchTxt" value="${param.searchTxt}"	/>
		<input type="hidden" name="page" value="${param.page}"	/>			
	</form>
	- 번호 : ${data.M_NO}<br>
	- 아이디 : ${data.M_ID}<br>
	- 비밀번호 : ${data.M_PW}<br>
	- 이름 : ${data.M_NM}<br>
	- 연락처 : ${data.M_PHONE}<br>
	- 가입일 : ${data.M_JOIN}<br>
	<input type="button" id="listBtn" value="목록으로" />
	<input type="button" id="updateBtn" value="수정" />
	<input type="button" id="deleteBtn" value="삭제" />
</body>
</html>