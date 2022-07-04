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
		$("#cancelBtn").on("click", function() {
			history.back();
		});
		
		$("#updateBtn").on("click", function() {
			if(checkVal("#ITEM_NAME")) {					
				alert("상품명을 입력하세요.");
				$("#ITEM_NAME").focus();
			} else if(checkVal("#COUNT")) {			
				alert("개수를 입력하세요.");
				$("#COUNT").focus();
			} else {
				$("#updateForm").submit();
			}
		});
	});	//doc end
	
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
	<form action="yhrUpdates" id="updateForm" method="post">
		<input type="hidden" name="searchGbn" value="${param.searchGbn}"/>
		<input type="hidden" name="searchTxt" value="${param.searchTxt}" />
		<input type="hidden" name="page" value="${param.page}" />
		<input type="hidden" name="NO" value="${data.NO}" />	
		번호 : ${data.NO}<br>										
		상품명 <input type="text" id="ITEM_NAME" name="ITEM_NAME" value="${data.ITEM_NAME}"/><br>			
		개수 <input type="text" id="COUNT" name="COUNT" value="${data.COUNT}"/><br>		
		판매일 <input type="text" id="SELL_DT" name="SELL_DT" value="${data.SELL_DT}"/><br>		
	</form>
	<input type="button" value="수정"	 id="updateBtn" />
	<input type="button" value="취소"	 id="cancelBtn" />
</body>
</html>