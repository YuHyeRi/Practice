<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp"%>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(function() {
		list();		
		$("#btnSave").click(function() {
			insert();
		});
		$("btnSearch").click(function() {
			list();
		});
	});
	function list() {
		// searchkey:검색옵션, search:검색키워드
		var param = "searchkey=" + $("#searchkey").val() + "&search=" + $("#search").val();
		$.ajax({
			data : param,
			url : "/jsp02/memo_servlet/list.do",
			success : function(result){
				$("#result").html(result);
			}
		});
	}
	function insert() {
		var writer = $("#writer").val();	// id가 writer인 태그에 입력 값을 변수 writer에 담음
		var memo = $("#memo").val();
		var param = "writer=" + writer + "&memo=" + memo;
		$.ajax({
			data : param,
			url : "/jsp02/memo_servlet/insert.do",
			success : function(){
				list("search=");
				$("#writer").val("");
				$("#memo").val("");
			}
		});
	}
</script>
</head>
<body>
	이름 : <input id="writer" size="10"><br>
	메모 : <input id="memo" size="40">
	<input type="button" id="btnSave" value="저장"><br>
	<select id="searchkey">
		<option value="writer">이름</option>
		<option value="memo">메모</option>
		<option value="writer_memo">이름+메모</option>
	</select>
	<input type="text" id="search" value="${search}">
	<input type="button" id="btnSearch" value="조회">
	<div id="result"></div>
</body>
</html>