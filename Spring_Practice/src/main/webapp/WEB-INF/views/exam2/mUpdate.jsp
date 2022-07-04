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
			if(checkVal("#M_PW")) {					
				alert("비밀번호를 입력하세요.");
				$("#M_PW").focus();
			} else if(checkVal("#M_NM")) {			
				alert("이름을 입력하세요.");
				$("#M_NM").focus();
			} else if(checkVal("#M_PHONE")) {			
				alert("연락처 입력하세요.");
				$("#M_PHONE").focus();
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
	<form action="mUpdates" id="updateForm" method="post">
		<!-- 얘네는 그냥 그대로 가지고 다닌다고 생각하기 -->
		<input type="hidden" name="searchGbn" value="${param.searchGbn}"/>
		<input type="hidden" name="searchTxt" value="${param.searchTxt}" />
		<input type="hidden" name="page" value="${param.page}" />
		<input type="hidden" name="M_NO" value="${data.M_NO}" />	
		번호 : ${data.M_NO}<br>										
		아이디 : ${data.M_ID}<br>			
		비밀번호 <input type="text" id="M_PW" name="M_PW" value="${data.M_PW}"/><br>		
		이름 <input type="text" id="M_NM" name="M_NM" value="${data.M_NM}"/><br>		
		연락처 <input type="text" id="M_PHONE" name="M_PHONE" value="${data.M_PHONE}"/><br>		
	</form>
	<input type="button" value="수정"	 id="updateBtn" />
	<input type="button" value="취소"	 id="cancelBtn" />
</body>
</html>