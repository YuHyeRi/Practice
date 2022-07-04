<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/script/jquery/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		/* 검색옵션 고정을 위한 방법 */
		if("${param.searchGbn}" != "") {
			$("#searchGbn").val("${param.searchGbn}");
		}
		
		/* 다소 드문 케이스만, 데이터 변조로 인하여 페이지가 총 페이지를 넘어가는 경우 */
		if("${page}" > "${pb.maxPcount}") {		
			$("#page").val("${page - 1}");
			$("#searchForm").submit();
		}
		
		$("tbody").on("click", "tr", function() {
			/* 여기서 this는 tr */
			$("#no").val($(this).attr("no"));
			/* dtlForm을 실행 하겠다 */
			$("#dtlForm").submit();
		});
		
		$("#searchBtn").on("click", function() {
			/* 서치시 페이지를 1페이지로 둠 */
			$("#page").val("1");	
			$("#searchForm").submit();
		});
		
		$("#addBtn").on("click", function() {
			location.href="testAdd";
		});
		
		$("#pagingWrap").on("click", "span", function() {
			$("#searchTxt").val($("#oldTxt").val());
			$("#page").val($(this).attr("page"));
			$("#searchForm").submit();
		});
		
		$("#loginBtn").on("click",function() {
			location.href="mLogin";
		});
		
		$("#logoutBtn").on("click",function() {
			location.href="mLogout";
		});
		
	});	// document ready end

</script>
</head>
<body>
	<c:choose>
		<c:when test="${empty sMNo}">	<!-- 비로그인 상태, empty는 많이씀 -->
			<input type="button" value="로그인" id="loginBtn">
		</c:when>
		<c:otherwise>
			<b>${sMNm}님 환영합니다!</b>
			<input type="button" value="로그아웃" id="logoutBtn">
		</c:otherwise>
	</c:choose>

	<form action="testDtl" id="dtlForm" method="post">
		<input type="hidden" name="no" id="no" />
		<input type="hidden" name="searchGbn" value="${param.searchGbn}" />
		<input type="hidden" name="searchTxt" value="${param.searchTxt}" />
		<input type="hidden" name="page" value="${page}" />
	</form>
	
	<!-- 검색을 위한 폼 -->
	<form action="testList" id="searchForm" method="post">
		<input type="hidden" name="page" id="page" value="${page}" />
		<select id="searchGbn" name="searchGbn">	
			<!-- choose(여러개의 조건을 처리할 때), when(if), otherwise(else) -->
			<%-- <c:choose>
				<c:when test="${param.searchGbn eq 0}">
					<option value="0" selected="selected">제목</option>
				</c:when>
				<c:otherwise>
					<option value="0">제목</option>
				</c:otherwise>
			</c:choose>
			<!-- 작성자로 검색하기 둘 -->
			<c:choose>
				<c:when test="${param.searchGbn eq 1}">
					<option value="1" selected="selected">작성자</option>
				</c:when>
				<c:otherwise>
					<option value="1">작성자</option>
				</c:otherwise>
			</c:choose> --%>
			<!-- 검색옵션 고정을 위한 방법 -->
			<option value="0">제목</option>
			<option value="1">작성자</option>
		</select>
		<!-- 여기서 value="${param.searchTxt}는 검색옵션을 유지를 위해 쓰려고 만듦 -->
		<input type="text" name="searchTxt" id="searchTxt" value="${param.searchTxt}" />
		<input type="hidden" id="oldTxt" value="${param.searchTxt}" />	<!-- oldTxt : 내가 했던 이력 (보관용) -->
		<input type="button" value="검색" id="searchBtn" />
		<input type="button" value="글쓰기" id="addBtn"	 />
	</form>
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
			<!-- 리스트를 받아서 data로 출력할거임 -->
			<c:forEach var="data" items="${list}">	
				<tr no="${data.NO}">
					<td>${data.NO}</td>
					<td>${data.TITLE}</td>
					<td>${data.WRITER}</td>
					<td>${data.DT}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<div id="pagingWrap">
		<span page="1">[처음]</span>
		<c:choose>
			<c:when test="${page eq 1}">
				<span page="1">[이전]</span>
			</c:when>
			<c:otherwise>
				<span page="${page - 1}">[이전]</span>
			</c:otherwise>
		</c:choose>
		<c:forEach var="i" begin="${pb.startPcount}" end="${pb.endPcount}" step="1">
			<c:choose>
				<c:when test="${page eq i}">
					<span page="${i}"><b>${i}</b></span>
				</c:when>
				<c:otherwise>
					<span page="${i}">${i}</span>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:choose>
			<c:when test="${page eq pb.maxPcount}">
				<span page="${pb.maxPcount}">[다음]</span>
			</c:when>
			<c:otherwise>
				<span page="${page + 1}">[다음]</span>
			</c:otherwise>
		</c:choose>
		<span page="${pb.maxPcount}">[마지막]</span>
	</div>
	
</body>
</html>