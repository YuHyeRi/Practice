<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/script/jquery/jquery-1.12.4.min.js"></script>
<script>
	var num = 1;
	
	$(document).ready(function() {
		$("#add1Btn").on("click", function() {
			num++;
			var html = "";
			// \(역슬래쉬) : 뒤에 오는 기능을 취소하고 그냥 글자로 읽겠다
			html += "<div>" + num + "<input type=\"button\" value=\"삭제\" class=\"delBtn\" /></div>";
			// 1. append : 엔티티 뒷 부분에 해당 내용을 추가
			// 인스타 등에 맨 아래 더보기 해서 아래로 추가로 뜨는 것들은 append
			$(".wrap").append(html);
			
			// 이벤트를 안에다가 하나하나씩 줄 경우
			// 그러나 누를때마다 이벤트가 누적되기 때문에 'off'를 써줌 (기존 이벤트를 제거)
			// 일반적으로 이 방법은 팝업이라던지 항시 떠있는 애가 없을 경우(비정기적일 경우) 이런식으로 씀
			/* $(".delBtn").off("click");
				$(".delBtn").on("click", function() {
				$(this).parent().remove();
				}); */
		});
		
		$("#add2Btn").on("click", function() {
			num++;
			var html = "";
			// 컨트롤 + F 
			// Find : ", replace with : \"
			// Scope : selected lines
			html += "<div>" + num + "<input type=\"button\" value=\"삭제\" class=\"delBtn\" /></div>";
			// 2. prepend : 엔티티 앞 부분에 해당 내용을 추가
			// 페북같이 새로운 내용이 위로 추가되는 것은 prepend
			$(".wrap").prepend(html);
		});
		
		$("#changeBtn").on("click", function() {
			num++;
			var html = "";
			html += "<div>" + num + "<input type=\"button\" value=\"삭제\" class=\"delBtn\" /></div>";
			// 3. html : 엔티티를 가져오거나 교체
			// html을 쓰면 아예 싸그리 바뀜(교체)
			// html()  : 엔티티를 가져옴
			// html(값) : 엔티티를 값으로 교체
			// 게시판의 경우 일반적으로 html을 많이 씀
			$(".wrap").html(html);
			console.log($(".wrap").html());
		});
		
		// on은 현재 화면에 있는 애한테만 event를 줄수 있음
		// 때문에 이벤트 주체를 상시 떠있는애 한테 주기(.wrap)
		$(".wrap").on("click", ".delBtn", function() {
			// this : delBtn
			$(this).parent().remove();
		});
		
		$("#resetBtn").on("click", function() {
			num = 0;
			// empty : 엔티티를 비움 (우리 키보드에 delete키 누른것과 같음)
			$(".wrap").empty();
		});
		
	});	// doc end
</script>
</head>
<body>
	<input type="button" value="append추가" id="add1Btn" />
	<input type="button" value="prepend추가" id="add2Btn" />
	<input type="button" value="교체" id="changeBtn" />
	<input type="button" value="초기화" id="resetBtn" />
	<div class="wrap">
		<div>1<input type="button" value="삭제" class="delBtn" /></div>
	</div>
</body>
</html>