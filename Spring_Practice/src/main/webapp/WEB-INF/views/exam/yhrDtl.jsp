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
			$("#actionForm").attr("action","yhrList");
			$("#actionForm").submit();
		});
		
		$("#updateBtn").on("click", function() {
			$("#actionForm").attr("action","yhrUpdate");		
			$("#actionForm").submit();
		});
		
		$("#deleteBtn").on("click", function() {
			if(confirm("정말 삭제하시겠습니까?")) {
				$("#actionForm").attr("action","yhrDelete");	
				$("#actionForm").submit();
			}
		});
	});	// doc end
</script>
</head>
<body>
	<form action="#" id="actionForm" method="post">							
		<input type="hidden" name="NO" value="${param.NO}"	/>
		<input type="hidden" name="searchGbn" value="${param.searchGbn}"	/>	
		<input type="hidden" name="searchTxt" value="${param.searchTxt}"	/>
		<input type="hidden" name="page" value="${param.page}"	/>			
	</form>

	- 번호 : ${data.NO}<br>
	- 상품명 : ${data.ITEM_NAME}<br>
	- 개수 : ${data.COUNT}<br>
	- 판매일 : ${data.SELL_DT}<br>
	<input type="button" id="listBtn" value="목록으로" />
	<input type="button" id="updateBtn" value="수정" />
	<input type="button" id="deleteBtn" value="삭제" />
</body>
</html>