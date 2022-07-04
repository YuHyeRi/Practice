<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/script/jquery/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#cancelBtn").on("click", function() {
			history.back();
		});
		
		$("#addBtn").on("click", function() {
			if(checkVal("#title")) {					// title이 비어있다면
				alert("제목을 입력하세요.");
				$("#title").focus();
			} else if(checkVal("#writer")) {			
				alert("작성자를 입력하세요.");
				$("#writer").focus();
			} else if(checkVal("#content")) {
				alert("내용 입력하세요.");
				$("#content").focus();
			} else {
				$("#addForm").submit();
			}
		});
	});	//document ready end
	
	function checkVal(sel) {
		/* trim() : 문자열 양 끝의 공백을 제거 */
		/* 문자열의 양 끝의 공백을 제거 후에도 ""(공백)이라면 그것도 공백으로 보는 것 */
		if($.trim($(sel).val()) == "") {	// sel을 받아오는데 양 옆에 공백을 제거하고 받아옴
			return true;
		} else {
			return false;
		}
	}
</script>
</head>
<body>
	<!-- testAdds라는 새로운 주소가 생겼으니 controller -->
	<form action="testAdds" id="addForm" method="post">	
		제목 <input type="text" id="title" name="title"	/><br>
		작성자 <input type="text" id="writer" name="writer" /><br>
		내용<br>
		<textarea rows="8" cols="40" id="content" name="content"></textarea>
	</form>
	<input type="button" value="저장"	 id="addBtn" />
	<input type="button" value="취소"	 id="cancelBtn" />
</body>
</html>