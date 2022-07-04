<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/script/jquery/jquery-1.12.4.min.js"></script>
<script>
	 $(document).ready(function() {
		if("${param.searchGbn}" != "") {
			$("#searchGbn").val("${param.searchGbn}");
		};
		$("tbody").on("click", "tr", function() {
			$("#no").val($(this).attr("no"));
			$("#dtlForm").submit();
		});
		$("#searchBtn").on("click", function() {
			$("#page").val("1");
			$("#searchForm").submit();
		});
		$("#addBtn").on("click", function() {
			location.href="mAdd";
		});
		$("#pagingWrap").on("click", "span", function() {
			$("#searchTxt").val($("#oldTxt").val());
			$("#page").val($(this).attr("page"));
			$("#searchForm").submit();
		});
	});	// doc end
</script>
</head>
<body>
	<form action="mDtl" id="dtlForm" method="post">
		<input type="hidden" name="M_NO" id="no" />
		<input type="hidden" name="searchGbn" value="${param.searchGbn}" />
		<input type="hidden" name="searchTxt" value="${param.searchTxt}" />
		<input type="hidden" name="page" value="${page}" />
	</form>
	<form action="mList" id="searchForm" method="post">
		<input type="hidden" name="page" id="page" value="${page}" />
		<select id="searchGbn" name="searchGbn">	
			<option value="0">아이디</option>
			<option value="1">이름</option>
		</select>
		<input type="text" name="searchTxt" id="searchTxt" value="${param.searchTxt}" />
		<input type="hidden" id="oldTxt" value="${param.searchTxt}" />
		<input type="button" value="검색" id="searchBtn"	/>
		<input type="button" value="가입" id="addBtn"	/>
	</form> 
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>연락처</th>
				<th>가입일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="data" items="${list}">
				<tr no="${data.M_NO}">	<!-- 위 input에 no -->
					<!-- 여기는 쿼리 컬럼명 그대로 가져다 써야함!! -->
					<td>${data.M_NO}</td>
					<td>${data.M_ID}</td>
					<td>${data.M_PW}</td>
					<td>${data.M_NM}</td>
					<td>${data.M_PHONE}</td>
					<td>${data.M_JOIN}</td>
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