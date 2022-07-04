<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	tbody {
		text-align : center;
	}
	.paging_wrap span {
   		cursor: pointer;
	}
	td img {
		width: 15px;
	}
</style>
<script type="text/javascript" src="resources/script/jquery/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		if("${param.searchGbn}" != "") {
			$("#searchGbn").val("${param.searchGbn}");
		}
		reloadList();
		
		// 글작성
		$("#addBtn").on("click", function() {
			$("#searchTxt").val($("#oldTxt").val());	// 취소시 검색어 유지를 위해 
			
			$("#actionForm").attr("action", "testABAdd");
			$("#actionForm").submit();
		});
		
		// 로그인
		$("#loginBtn").on("click", function() {
			location.href="mLogin";
		});
		
		// 로그아웃
		$("#logoutBtn").on("click", function() {
			location.href="mLogout";
		});
		
		// 검색
		$("#searchBtn").on("click", function() {
			$("#oldTxt").val($("#searchTxt").val());	// 페이징해도 검색어 유지
			$("#page").val("1");
			reloadList();
		});
		
		// 검색어 입력 후, 엔터를 누르면 검색됨 (마치 서치버튼 누른 것 처럼)
		// 이걸 안하고 검색+엔터하면 주소 뒤에 샵이 뜸
		// keypress : 키보드 이벤트 타입
		$("#searchTxt").on("keypress", function(event) {
			if(event.keyCode == 13) {			// 엔터키를 치면
				$("#searchBtn").click();
				return false;					// 나머지 하던 일은 멈춰라
			}
		});
		
		// 페이징
		$(".paging_wrap").on("click", "span", function() {
			$("#page").val($(this).attr("page"));
			$("#searchTxt").val($("#oldTxt").val());	
			reloadList();
		});
		
		// 상세보기
		// on이벤트를 줄 때는 상시 떠있는 애 한테 주기 (tr은 페이징하면서도 사라질수있고 변동성이 있기 때문에 주지 않음)
		// 여기서 no는 name
		$("tbody").on("click", "tr", function() {
			$("#no").val($(this).attr("no"));
			
			$("#actionForm").attr("action", "testAB");	// testAb : 상세보기
			$("#actionForm").submit();
		});
		
		
	}); // doc end
	
	
	// 데이터 취득용 함수
	function reloadList() {
		// serialize : form의 객체들을 한번에 받을 수 있음
		// serialize : 받은 데이터들을 문자열화 시킴
		// $("form id & name").serialize();
		var params = $("#actionForm").serialize();	// form의 데이터를 문자열로 변환
		
		$.ajax({						
			url: "testABLists",			// 접속주소	
			type: "post",				// 전송방식
			dataType: "json",			// 받아올 데이터 형태 (json, xml, ...)
			data: params,				// 보낼 데이터(문자열 형태)
			success: function(res) {	// ajax 통신 성공시 다음 함수 실행 (res는 편한대로.. 받아온 결과를 res에 담음)
				drawList(res.list);		
				drawPaging(res.pb);
			},
			error: function(request, status, error) {	// ajax 통신 실패시 다음 함수 실행
				console.log(error);
			}
		});
	};
	
	// alt + shift + A
	// 목록 그리기용 함수
	// 첨부파일 아이콘은 여기와 쿼리(list)부분만 수정하면 됨
	function drawList(list){
		var html = "";
		
		for(var data of list){
			html += "<tr no=\"" + data.B_NO + "\">			";                     
			html += "<td>" + data.B_NO + "</td>	";
			html += "<td>";
			html +=  data.B_TITLE;
			
			if(data.B_FILE != null) {	// 중요! 아작스에서 데이터를 가져온 값이 없을때는 null로 비교
				html += "<img src=\"resources/images/file.png\" />";
			}
			
			html +=  "</td>	";
			html += "<td>" + data.M_NM + "</td>	";
			html += "<td>" + data.B_DT + "</td>	";
			html += "<td>" + data.B_HIT + "</td>	";
			html += "</tr>			";  
		}
		
		$("tbody").html(html);
	};
	
	// 페이징을 그려줄 함수
	function drawPaging(pb){
		var html = "";
		
		html += "<span page=\"1\">[처음]</span>	";
		
		if($("#page").val() == "1") {
			html += "<span page=\"1\">[이전]</span>	";
		} else {
			html += "<span page=\"" + ($("#page").val() * 1 - 1) + "\">[이전]</span>	";
		} // 문자열 숫자일 때 * 연산을 하면 숫자로 형변환
		
		for(var i=pb.startPcount; i<=pb.endPcount; i++) {
			if($("#page").val() == i) {
				html += "<span page=\"" + i + "\"><b>" + i + "</b></span>	";
			} else {
				html += "<span page=\"" + i + "\">" + i + "</span>	";
			}
		}
		
		if($("#page").val() == pb.maxPcount) {
			html += "<span page=\"" + pb.maxPcount + "\">[다음]</span>	";
		} else {
			html += "<span page=\"" + ($("#page").val() * 1 + 1) + "\">[다음]</span>	";
		}
		
		html += "<span page=\"" + pb.maxPcount + "\">[마지막]</span>	";
		
		$(".paging_wrap").html(html);
	};
</script>
</head>
<body>
	<div>
		<c:choose>
			<c:when test="${empty sMNo}">
				<input type="button" value="로그인" id="loginBtn" />
			</c:when>
			<c:otherwise>
				<b>${sMNm}님</b> 어서오세요.
				<input type="button" value="로그아웃" id="logoutBtn" />
			</c:otherwise>
		</c:choose>
	</div>
	
	<div>
		<form action="#" id="actionForm" method="post">
			<select name="searchGbn" id="searchGbn">
				<option value="0">제목</option>
				<option value="1">작성자</option>
			</select>
			<input type="text" name="searchTxt" id="searchTxt" value="${param.searchTxt}" />
			<!-- 가지고 다닐것들 -->
			<input type="hidden" id="oldTxt" value="${param.searchTxt}" />
			<input type="hidden" name="page" id="page" value="${page}" />
			<input type="hidden" name="no" id="no" />
			<!-- 가지고 다닐것들 -->
			<input type="button" value="검색" id="searchBtn" />
			<c:if test="${!empty sMNo}">
				<input type="button" value="작성" id="addBtn" />
			</c:if>
		</form>
	</div>
	
	<div>
		<table border="1">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</div>
	
	<div class="paging_wrap">
	</div>
</body>
</html>