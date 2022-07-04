<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/script/jquery/jquery-1.12.4.min.js"></script>
<script>
	$(document).ready(function() {
		// 목록버튼
		$("#listBtn").on("click", function() {
			$("#actionForm").attr("action", "testMList");
			$("#actionForm").submit();
		});
		
		// 수정버튼
		$("#updateBtn").on("click", function() {
			$("#actionForm").attr("action", "testMUpdate");	// testMUpdate 컨트롤러 추가
			$("#actionForm").submit();
		});
		
		// 삭제버튼
		$("#delBtn").on("click", function() {
			if(confirm("정말 삭제하시겠습니까?")) {
				var params = $("#actionForm").serialize();
				
				$.ajax({
					url: "testMAdds",	// testMDelelte 컨트롤러 생성(RequestMapping, ResponseBody)
					type: "post",
					data: params,
					dataType: "json",
					success: function(res) {
						if(res.result == "success") {
							location.href = "testMList";
						} else if(res.result == "failed") {
							alert("삭제에 실패하였습니다.!");
						} else {
							alert("삭제중 문제가 발생했습니다.");
						}
					}, 
					error: function(request, status, error) {
						console.log(error);
					}
				});
			}
		});
	}); // doc end
</script>
</head>
<body>
	<!-- 가지고다님 -->
	<form action="#" id="actionForm" method="post">
		<input type="hidden" name="gbn" value="d" />
		<input type="hidden" name="searchGbn" value="${param.searchGbn}" />
		<input type="hidden" name="searchTxt" value="${param.searchTxt}" />
		<input type="hidden" name="page" value="${param.page}" />
		<input type="hidden" name="no" value="${param.no}" />
	</form>
	<input type="button" value="목록" id="listBtn" />
	<input type="button" value="수정" id="updateBtn" />
	<input type="button" value="삭제" id="delBtn" />
	<div>회원번호 : ${data.M_NO}</div>
	<div>아이디 : ${data.M_ID}</div>
	<div>비밀번호 : ${data.M_PW}</div>
	<div>이름 : ${data.M_NM}</div>
	<div>전화번호 : ${data.M_PHONE}</div>
	<div>가입일 : ${data.M_JOIN}</div>
	
	<c:if test="${!empty data.M_IMG}"> 
		<div>
			<c:set var="len" value="${fn:length(data.M_IMG)}"></c:set>
			프로필 :
			<a href="resources/upload/${fn:replace(fn:replace(data.M_IMG, '[', '%5B'), ']', '%5D')}" download="${fn:substring(data.M_IMG, 20, len)}">
			<%-- <a href="resources/upload/${data.M_IMG}" download="${fn:substring(data.M_IMG, 20, len)}"> --%>
			${fn:substring(data.M_IMG, 20, len)}
			</a>
		</div>
		<div>
			<img src="resources/upload/${fn:replace(fn:replace(data.M_IMG, '[', '%5B'), ']', '%5D')}" width="100px" height="100px" />
		</div>
	</c:if>
</body>
</html>