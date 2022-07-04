<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#att {
		display: none;
	}
	.hide_btn {
		display: none;
	}
	#img {
		width: 100px;
		height: 100px;
	}
</style>
<script type="text/javascript" src="resources/script/jquery/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="resources/script/jquery/jquery.form.js"></script>
<script>
	$(document).ready(function() {
		// 글작성시 엔터 방지
		$("#addForm").on("keypress", function(event) {
			if(event.keyCode == 13) {
				return false;
			} 
		});
		
		// 취소버튼
		$("#cancelBtn").on("click", function() {
			history.back();
		});
		
		// 첨부파일 버튼
		$("#fileBtn").on("click", function() {
			$("#att").click();
		});
		
		// 첨부파일 선택시
		$("#att").on("change", function() {
			$("#fileName").html($(this).val().substring($(this).val().lastIndexOf("\\")+1));
		});
		
		// 첨부파일 삭제 버튼
		$("#fileDelBtn").on("click", function() {
			$("#fileName").html("");
			$("#mFile").val("");
			$("#fileBtn").attr("class", "");
			$(this).remove();
			$("#img").remove();
		});
		
		// 수정버튼
		$("#updateBtn").on("click", function() {
			if($("#pw").val() != "") { 				// 비밀번호를 변경할 경우
				if(checkVal("#ocpw")) { 			// 기존비밀번호 입력여부
					alert("기존 비밀번호를 입력해 주세요.");
					$("#ocpw").focus();
				} else if($("#opw").val() == $("#ocpw").val()) { 	// 실 비밀번호와 입력된 기존비밀번호 비교
					if(checkVal("#repw")) {
						alert("비밀번호 확인을 입력해 주세요.");
						$("#repw").focus();
					} else if($("#pw").val() != $("#repw").val()) {
						alert("비밀번호 확인이 일치하지 않습니다.");
						$("#pw").val("");
						$("#repw").val("");
						$("#pw").focus();
					} else if(checkVal("#nm")) {
						alert("이름을 입력해 주세요.");
						$("#nm").focus();
					} else {
						updateAjax();
					}
				} else { 	// 비교 결과 같지 않은 경우
					alert("기존 비밀번호가 일치하지 않습니다.");
					$("#ocpw").val("");
					$("#ocpw").focus();
				}
			} else if(checkVal("#nm")) {
				alert("이름을 입력해 주세요.");
				$("#nm").focus();
			} else {
				updateAjax();
			}
		});	// btn end
	}); // doc end
	
	// update 관련 Func
	function updateAjax() {
		var fileForm = $("#fileForm");
		
		fileForm.ajaxForm({
			success: function(res) {
				if(res.result == "SUCCESS") {
					if(res.fileName.length>0) {
						$("#mFile").val(res.fileName[0]);
					}
					
					var params = $("#updateForm").serialize();
					$.ajax({
						url: "testMAdds",
						type: "post",
						data: params,
						dataType: "json",
						success: function(res) {
							if(res.result == "success") {
								$("#backForm").attr("action", "testMDtl");
								$("#backForm").submit();
							} else if(res.result == "failed") {
								alert("수정에 실패하였습니다.");
							} else {
								alert("수정중 문제가 발생했습니다.");
							}
						}, 
						error: function(request, status, error) {
							console.log(error);
						}
					});
				} else {
					alert("파일 업로드에 실패하였습니다.");
				}
				},
				error: function(req, status, error) {
					console.log(error);
					alert("파일 업로드 중 문제가 발생하였습니다.");
				}
		});
		fileForm.submit();
	};
	
	// 입력확인용 Func
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
	<!-- 파일 폼 추가 -->
	<form id="fileForm" action="fileUploadAjax" method="post" enctype="multipart/form-data">
		<input type="file" name="att" id="att" accept="image/*" />
	</form>
	
	<!-- 가지고다님, 수정 취소시 상세보기로 넘어감 -->
	<!-- 비동기에서는 history.back()사용시 검색상태, 검색결과유지가 안되어서 backForm -->
	<!-- <form action="testMDtl" id="backForm" method="post"> -->
	<form action="#" id="backForm" method="post">
		<input type="hidden" name="searchGbn" value="${param.searchGbn}" />
		<input type="hidden" name="searchTxt" value="${param.searchTxt}" />
		<input type="hidden" name="page" value="${param.page}" />
		<input type="hidden" name="no" value="${param.no}" />
	</form>
	
	<form action="#" id="updateForm" method="post">
		<input type="hidden" name="gbn" value="u" />
		ο 회원번호 : ${data.M_NO} <input type="hidden" name="no" value="${param.no}" /><br/>
		ο 아이디 : ${data.M_ID}<br/>
		<!-- 비밀번호 관련 시작 -->
		<input type="hidden" id="opw" value="${data.M_PW}" />
		ο 기존 비밀번호 : <input type="password" id="ocpw" /><br/>
		ο 비밀번호 : 	 <input type="password" id="pw" name="pw" /><br/>
		ο 비밀번호 확인 : <input type="password" id="repw" /><br/>
		<!-- 비밀번호 관련 끝 -->
		ο 이름 : <input type="text" id="nm" name="nm" value="${data.M_NM}"/><br/>
		ο 전화번호 : <input type="text" id="phone" name="phone" value="${data.M_PHONE}" /><br/>
		ο 가입일 : ${data.M_JOIN}<input type="hidden" name="join" /><br/>
		ο 프로필 :
		<c:choose>
			<c:when test="${!empty data.M_IMG}">
				<input type="button" value="이미지추가" id="fileBtn" class="hide_btn" />
			</c:when>
			<c:otherwise>
				<input type="button" value="이미지추가" id="fileBtn" />
			</c:otherwise>
		</c:choose>
		<c:set var="len" value="${fn:length(data.M_IMG)}"></c:set>
		<span id="fileName">${fn:substring(data.M_IMG, 20, len)}</span>	
		<c:if test="${!empty data.M_IMG}">
			<input type="button" value="이미지삭제" id="fileDelBtn"/><br>
			<img id="img" src="resources/upload/${fn:replace(fn:replace(data.M_IMG, '[', '%5B'), ']', '%5D')}" width="150px" height="150px" />
		</c:if>
		<input type="hidden" name="mFile" id="mFile" value="${data.M_IMG}" /><br/>
	</form>
	<input type="button" value="수정" id="updateBtn" />
	<input type="button" value="취소" id="cancelBtn" />
</body>
</html>