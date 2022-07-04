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
</style>
<script type="text/javascript" src="resources/script/jquery/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="resources/script/jquery/jquery.form.js"></script> <!-- 폼 추가 -->
<script type="text/javascript" src="resources/script/ckeditor/ckeditor.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		CKEDITOR.replace("con", {
			resize_enabled : false,		// 드래그하여 크기조정으로 false로 막아놓음
			language : "ko",
			enterMode : "2"				// enter를 submit이 아닌 줄바꿈으로 인식
		});
		
		// 취소버튼
		$("#cancelBtn").on("click", function() {
			$("#backForm").submit();
		});
		
		// 글작성시 엔터키 폼 실행 막기 (필수!)
		$("#addForm").on("keypress", "input", function(event) {
			if(event.keyCode == 13) {	// 엔터키가 눌러졌을 때
				return false;			// form실행 이벤트를 하지않음
			}
		});
		
		// 첨부파일 버튼 (버튼을 눌렀을때 input=file이 실행됨으로써 버튼의 디자인이 자유로워짐)
		$("#fileBtn").on("click", function() {
			$("#att").click();
		});
		
		// 첨부파일 선택시
		$("#att").on("change", function() {
			// 마지막 역 슬래쉬(마지막 폴더)에서 마지막만 잘라서 문구를 가져오겠다, 앞에 뺵슬러쉬 쓰는 이유는 얘를 문구로 인식하게 위해
			$("#fileName").html($(this).val().substring($(this).val().lastIndexOf("\\") + 1));
		});
		
		// 저장버튼
		$("#addBtn").on("click", function() {
			// ck에디터 중에 con과 관련된 객체에서 데이터를 취득하여 textarea인 con에 값을 넣음
			$("#con").val(CKEDITOR.instances['con'].getData());
			if(checkVal("#title")) {
				alert("제목을 입력하세요.");
				$("#title").focus();
			} else if(checkVal("#con")) {
				alert("내용 입력하세요.");
			} else {
				var fileForm = $("#fileForm");
				
				fileForm.ajaxForm({
					success: function(res) {
						if(res.result == "SUCCESS") {
							// 업로드 파일명 적용
							if(res.fileName.length > 0) {	// fileUpload.컨트롤러에 있음(fileName)
								$("#bFile").val(res.fileName[0]);
							}
							// 글 저장 (아래에 ajax 그대로 복붙)
							var params = $("#addForm").serialize();		
							
							$.ajax({
								url: "testABAdds",
								type: "post",
								dataType: "json",
								data: params,
								success: function(res) {
									if(res.result == "success") {
										location.href="testABList";
									} else if(res.result == "failed") {
										alert("작성에 실패하였습니다.");
									} else {
										alert("작성중 문제가 발생하였습니다.");
									}
								},
								error: function(request, status, error) {
									console.log(error);
								}
							});
						} else {
							alert("파일 업로드에 실패하였습니다!");
						}
					},
					error: function(req, status, error) {
						console.log(error);
						alert("파일 업로드 중 문제가 발생하였습니다!");
					}
				});
				
				fileForm.submit();
			}
		});
	});	// doc end
	
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
		<input type="file" name="att" id="att" />
	</form>
	
	<!-- 취소 뒤로가기용 폼 : 취소시 검색어와 페이지를 유지하게 하려고 다 들고 다님 -->
	<form action="testABList" id="backForm" method="post">
		<input type="hidden" name="searchGbn" value="${param.searchGbn}" />
		<input type="hidden" name="searchTxt" value="${param.searchTxt}" />
		<input type="hidden" name="page" value="${param.page}" />
	</form>
	
	<form action="#" id="addForm" method="post">
		제목 <input type="text" id="title" name="title" /><br/>
		작성자 ${sMNm}<input type="hidden" name="mno" value="${sMNo}" /><br/>
		<!-- textarea에 에디터를 달기 위해서 id와 name을 줌 -->
		<textarea rows="5" cols="5" id="con" name="con"></textarea><br/>
		첨부파일 : <input type="button" value="첨부파일선택" id="fileBtn" /><span id="fileName"></span>
		<input type="hidden" name="bFile" id="bFile" />	<!-- DB저장용 -->
	</form>
	<input type="button" value="저장" id="addBtn" />
	<input type="button" value="취소" id="cancelBtn" />
</body>
</html>