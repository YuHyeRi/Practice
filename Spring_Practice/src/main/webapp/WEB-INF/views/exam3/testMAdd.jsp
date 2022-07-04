<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#att {
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
		
		// 아이디 중복체크 (change : 변경되었을 때)
		$("#id").on("change", function() {
			var params = $("#addForm").serialize();
			
			$.ajax({
				url: "testMIdCheck",		// controller 생성
				type: "post",
				data: params,
				dataType: "json",
				success: function(res) {
					if(res.cnt > 0) {
						$("#check").html(" 중복된 아이디가 있습니다.");
						$("#check").css("color", "red");
						$("#checkId").val("false");
					} else {
						$("#check").html(" 사용가능한 아이디 입니다.");
						$("#check").css("color", "green");
						$("#checkId").val("true");
					}
				},
				error: function(request, status, error) {
					console.log(error);
				}
			});
		});
		
		// 취소버튼
		$("#cancelBtn").on("click", function() {
			$("#backForm").submit();
		});
		
		// 첨부파일 버튼
		$("#fileBtn").on("click", function() {
			$("#att").click();
		});
		
		// 첨부파일 선택
		$("#att").on("change", function() {
			$("#fileName").html($(this).val().substring($(this).val().lastIndexOf("\\")+1));
		});
		
		// 저장버튼
		$("#addBtn").on("click", function() {
			if(checkVal("#id")) {
				alert("아이디를 입력하세요.");
				$("#id").focus();
			} else if($("#checkId").val() == "false") {
				alert("아이디 중복 체크를 해주세요.");
				$("#id").focus();
			} else if(checkVal("#pw")) {
				alert("비밀번호를 입력하세요.");
				$("#pw").focus();
			} else if(checkVal("#repw")) {
				alert("비밀번호 확인을 입력하세요.");
				$("#repw").focus();
			} else if($("#pw").val() != $("#repw").val()) {
				alert("비밀번호가 일치하지 않습니다.");
				$("#pw").val("");
				$("#repw").val("");
				$("#pw").focus();
			} else if(checkVal("#nm")) {
				alert("이름을 입력하세요.");
				$("#nm").focus();
			} else if(checkVal("#phone")) {
				alert("전화번호를 입력하세요.");
				$("#phone").focus();
			} else {
				var fileForm = $("#fileForm");
				fileForm.ajaxForm({
					success: function(res) {
						if(res.result == "SUCCESS") {
							if(res.fileName.length > 0) {
								$("#mFile").val(res.fileName[0]);
							}
							var params = $("#addForm").serialize();	
							
							$.ajax({
								url: "testMAdds",	
								type: "post",
								data: params,
								dataType: "json",
								success: function(res) {
									if(res.result == "success") {
										location.href = "testMList";
									} else if(res.result == "failed") {
										alert("작성에 실패하였습니다.")
									} else {
										alert("작성 중 문제가 발생하였습니다.")
									}
								},
								error: function(request, status, error) {
									console.log(error);
								}
							})
						} else {
							alert("파일 업로드에 실패하였습니다.");
						}
					}, error: function(req, status, error) {
						console.log(error);
						alert("파일 업로드 중 문제가 발생하였습니다.");
					}
				});
				
				fileForm.submit();
			}
		});
	}); // doc end
	
	// 입력확인용 Func
	function checkVal(sel) {
		if($.trim($(sel).val()) == "") {	
			return true;
		} else {
			return false;
		}
	}
	
	// 이미지 미리보기 Func
	function readURL(input) {
		if(input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$("#img").attr("src", e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
</script>
</head>
<body>
	<!-- 파일 폼 추가 -->
	<form id="fileForm" action="fileUploadAjax" method="post" enctype="multipart/form-data">
		<input type="file" name="att" id="att" accept="image/*" onchange="readURL(this)" />
	</form>
	
	<!-- 가지고다님, 작성 중 취소시 리스트로 넘어감 -->
	<!-- 비동기에서는 history.back()사용시 검색상태, 검색결과유지가 안되어서 backForm -->
	<form action="testMList" id="backForm" method="post">
		<input type="hidden" name="searchGbn" value="${param.searchGbn}" />
		<input type="hidden" name="searchTxt" value="${param.searchTxt}" />
		<input type="hidden" name="page" value="${param.page}" />
		<input type="hidden" name="no" value="${param.no}" />
	</form>
	
	<form action="#" id="addForm" method="post">
		<input type="hidden" name="gbn" value="c" />
		<input type="hidden" id="checkId" value="false" />
		ο 아이디	<input type="text" id="id" name="id" /><span id="check"></span><br/> <!-- span : 문구 넣으려고 -->
		ο 비밀번호	<input type="password" id="pw" name="pw" /><br/>
		ο 비밀번호 확인 <input type="password" id="repw"><br/>
		ο 이름		<input type="text" id="nm" name="nm" /> <br/>
		ο 전화번호	<input type="text" id="phone" name="phone" /><br/>
		ο 프로필 <input type="button" value="이미지등록" id="fileBtn" /> <span id="fileName"></span>
		<input type="hidden" id="mFile" name="mFile" /><br/><br/>
		<img id="img" src="#" onerror="this.src='resources/images/profile.png'" />
	</form>
	<input type="button" value="저장" id="addBtn" />
	<input type="button" value="취소" id="cancelBtn" />
</body>
</html>