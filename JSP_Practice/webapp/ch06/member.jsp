<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	// 이름 없는 함수
	$(function() {		// 페이지 로딩 후 자동으로 실행
		list();
		$("#btnSave").click(function() {	// 버튼을 클릭하면
			insert();
		});
	});
	function insert() {	// 서버에 전달할 파라미터 key=value&key=value
		// $("태그").val() 태그에 입력한 값
		// $("태그").val(변경할값) 태그의 입력값을 변경
		var param = "userid=" + $("#userid").val() + "&passwd=" + $("#passwd").val() +
					"&name=" + $("#name").val() + "&address=" + $("#address").val() +
					"&tel=" + $("#tel").val();
		$("#tel").val();
		// 백그라운드에서 실행되는 코드, url주소, data 전달하는 값, success 콜백함수
		// 콜백함수 - 서버에서 처리가 완료된 후 실행되는 함수
			$.ajax( {
				type : "post",
				url : "/jsp02/member_servlet/join.do",	// key:url, value:"url주소"
				data : param,
				success : function() {
					list();
					// val() : 태그의 값을 읽기만함
					// val(값) : 쓰기, 값으로 바꾸기
					$("#userid").val("");	// id가 userid인 태그에 입력된 값을 지움
					$("#passwd").val("");
					$("#name").val("");
					$("#adderss").val("");
					$("#tel").val("");
					$("#userid").focus();	// focus : 입력포커스 깜빡
				}
			});
	}
		function list() {
			// 백그라운드로 실행되는 코드
			$.ajax( {
				url : "/jsp02/member_servlet/list.do",
				success : function(result) {			// success : 콜백함수(서버에서 처리가 완료된 후 실행되는 함수)
					// 서버의 출력값이 result 변수에 복사됨
					// id가 memberList인 태그에 result가 출력됨
					$("#memberList").html(result);
				}
			});
		}
</script>
</head>
<body>
	<!--비동기식으로 할거라서 form을 안씀-->
	아이디 <input id="userid"><br>
	비번 <input type="password" id="passwd"><br>
	이름 <input id="name"><br>
	주소 <input id="address"><br>
	전화 <input id="tel"><br>
	<button id="btnSave">추가</button>
	<div id="memberList"></div>
</body>
</html>