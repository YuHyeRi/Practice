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
		$("#addBtn").on("click", function() {
			if(checkVal("#M_ID")) {					
				alert("아이디를 입력하세요.");
				$("#M_ID").focus();
			} else if(checkVal("#M_PW")) {			
				alert("비밀번호를 입력하세요.");
				$("#M_PW").focus();
			} else if(checkVal("#M_NM")) {			
				alert("이름을 입력하세요.");
				$("#M_NM").focus();
			} else if(checkVal("#M_PHONE")) {			
				alert("연락처 입력하세요.");
				$("#M_PHONE").focus();
			} else {
				$("#addForm").submit();
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
	<form action="mAdds" id="addForm" method="post">	
		아이디 <input type="text" id="M_ID" name="M_ID" /><br>
		비밀번호 <input type="password" id="M_PW" name="M_PW" /><br>
		이름 <input type="text" id="M_NM" name="M_NM" /><br>
		연락처 <input type="text" id="M_PHONE" name="M_PHONE" /><br>
	</form>
	<input type="button" value="저장"	 id="addBtn" />
	<input type="button" value="취소"	 id="cancelBtn" />
</body>
</html>