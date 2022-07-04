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
<script type="text/javascript">
	$(document).ready(function() {
		// 목록버튼
		$("#listBtn").on("click", function() {
			$("#actionForm").attr("action", "testABList");
			$("#actionForm").submit();
		});
		
		// 수정버튼 > testABUpdate 컨트롤러 생성
		$("#updateBtn").on("click", function() {
			$("#actionForm").attr("action", "testABUpdate");
			$("#actionForm").submit();
		});
		
		// 삭제버튼 > testABDeletes 컨트롤러 생성
		$("#deleteBtn").on("click", function() {
			if(confirm("삭제하시겠습니까?")) {
				var params = $("#actionForm").serialize();		
				
				$.ajax({
					url: "testABDeletes",
					type: "post",
					dataType: "json",
					data: params,
					success: function(res) {
						if(res.result == "success") {
							location.href = "testABList";
						} else if(res.result == "failed") {
							alert("삭제에 실패하였습니다.");
						} else {
							alert("삭제중 문제가 발생하였습니다.");
						}
					},
					error: function(request, status, error) {
						console.log(error);
					}
				});
			}
		});
		
		
		
	});	// doc end
</script>
</head>
<body>
	<!-- 상태값 유지를 위해 값을 가지고 다녀야함(비동기의 단점) -->
	<form action="#" id="actionForm" method="post">
		<input type="hidden" name="searchGbn" value="${param.searchGbn}" />
		<input type="hidden" name="searchTxt" value="${param.searchTxt}" />
		<input type="hidden" name="page" value="${param.page}" />
		<input type="hidden" name="no" value="${param.no}" />
	</form>
	<div>
		번호 : ${data.B_NO}
	</div> 
	<div>
		제목 : ${data.B_TITLE}
	</div> 
	<div>
		작성자 : ${data.M_NM}
	</div> 
	<div>
		작성일 : ${data.B_DT}
	</div> 
	<div>
		조회수 : ${data.B_HIT}
	</div> 
	<div>
		내용 ▽<br/>
		${data.B_CON}
	</div> 
	<c:if test="${!empty data.B_FILE}">
		<div>
			<!-- c:set => 변수선언 -->
			<!-- fn:length(값) => 문자열이라면 문자열길이, 리스트나 배열이라면 갯수를 나타냄 -->
			<c:set var="len" value="${fn:length(data.B_FILE)}"></c:set>
			첨부파일 : 
			<!-- fn:substring(값, 숫자1, 숫자2) => 인덱스기반(0부터시작) 숫자1번째부터 숫자2미만까지 자름 -->
			<!-- a의 donwload : href의 파일을 다운로드 하겠다. 만약 download에 값이 있는 경우 해당 이름으로 다운로드 하겠다. -->
			<%-- <a href="resources/upload/${data.B_FILE}" download="${fn:substring(data.B_FILE, 20, len)}"> --%>
			<a href="resources/upload/${fn:replace(fn:replace(data.B_FILE, '[', '%5B'), ']', '%5D')}" download="${fn:substring(data.B_FILE, 20, len)}">
			${fn:substring(data.B_FILE, 20, len)}
			</a>
		</div>
	</c:if>
	<c:if test="${data.M_NO eq sMNo}">
		<input type="button" value="수정" id="updateBtn" /> 
		<input type="button" value="삭제" id="deleteBtn" /> 
	</c:if>
	<input type="button" value="목록" id="listBtn" /> 
</body>
</html>