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
		text-align: center;
	}
	#paging_wrap span {
		cursor: pointer;
	}
	td img {
		width: 15px;
	}
</style>
<script type="text/javascript" src="resources/script/jquery/jquery-1.12.4.min.js"></script>
<script>
	$(document).ready(function() {
		if("${param.searchGbn}" != "") {
			$("#searchGbn").val("${param.searchGbn}");
		}
		reloadList();
		
		// 검색버튼
		$("#searchBtn").on("click", function() {
			$("#oldTxt").val($("#searchTxt").val());
			$("#page").val("1");
			reloadList();
		});
		
		// 작성버튼, testMAdd 컨트롤러 추가
		$("#addBtn").on("click", function() {
			$("#searchTxt").val($("#oldTxt").val());
			$("#actionForm").attr("action", "testMAdd");
			$("#actionForm").submit();
		});
		
		// paging
		$("#paging_wrap").on("click", "span", function() {
			$("#page").val($(this).attr("page"));
			$("#searchTxt").val($("#oldTxt").val());
			reloadList();
		});
		
		// 검색버튼 엔터 방지 (url뒤에 # 안뜨면 정상)
		$("#searchTxt").on("keypress", function(event) {
			if(event.keyCode == 13) {
				$("#searchBtn").click();
				return false;
			}
		});
		
		// 상세보기, testMDtl 컨트롤러 추가
		$("tbody").on("click", "tr", function() {
			$("#no").val($(this).attr("no"));
			$("#searchTxt").val($("#oldTxt").val());
			$("#actionForm").attr("action", "testMDtl");
			$("#actionForm").submit();
		});
		
	});	// doc end
	
	// 데이터 취득용 func
	function reloadList() {
		var params = $("#actionForm").serialize();
		
		$.ajax({					
			url: "testMLists",		// testMLists 컨트롤러 생성(RequestMapping, ResponseBody)
			type: "post",			
			data: params,			
			dataType: "json",		
			success: function(res) {
				drawList(res.list);
				drawPaging(res.pb);
			},
			error: function(request, status, error) {
				console.log(error);
			}
		});
	};
	
	// list func
	function drawList(list) {
		var html = "";
		
		for(var data of list) {
			html += "<tr no=\"" + data.M_NO + "\">  ";
			html += "<td>" + data.M_NO + "</td>   	";
			html += "<td>" + data.M_ID + "</td>  	";
			html += "<td>" ;
			html += data.M_NM;
			
			if(data.M_IMG != null) {
				html += "<img src=\"resources/images/file.png\" />";
				/* html += "<img src=\"" + "resources/upload/" + data.M_IMG + "\" />"; */
			}
			
			html += "</td>";
			html += "<td>" + data.M_PHONE + "</td>	";
			html += "<td>" + data.M_JOIN + "</td> 	";
			html += "</tr>               			";
		}
		$("tbody").html(html);
	};
	
	// paging func
	function drawPaging(pb) {
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
		
		$("#paging_wrap").html(html);
	};
</script>
</head>
<body>
	<div>
		<form action="#" id="actionForm" method="post">
			<select id="searchGbn" name="searchGbn">
				<option value="0">아이디</option>
				<option value="1">이름</option>
				<option value="2">전화번호</option>
			</select>
			<input type="text" id="searchTxt" name="searchTxt" value="${param.searchTxt}" /><!-- 현재검색어 -->
			<!-- 가지고다님 -->
			<input type="hidden" id="oldTxt" value="${param.searchTxt}" />
			<input type="hidden" name="page" id="page" value="${page}" />
			<input type="hidden" name="no" id="no" />
			
			<input type="button" value="검색" id="searchBtn" />
			<input type="button" value="추가" id="addBtn" />
		</form>
	</div>
	
	<div>
		<table border="1">
			<thead>
				<tr>
					<th>회원번호</th>
					<th>아이디</th>
					<th>이름</th>
					<th>전화번호</th>
					<th>가입일</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</div>
	
	<div id="paging_wrap"></div>
</body>
</html>