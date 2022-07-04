<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table {
		border : 1px solid;
		border-collapse : collapse;
	}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		$.getJSON("item.json", function(data, textStatus) {
			// append() : 내용 추가
			// tr : 타이틀, 헤더 추가
			$("#fruit").append("<tr><td>id</td><td>과일</td> <td>가격</td>"  
								+ "<td>비고</td></tr>");
			// data : 전체 json 데이터
			$.each(data, function() {
				$("#fruit").append("<tr><td>" + this.id + "</td>" + "<td>" + this.name +
						"</td><td>"+this.price+"</td>" +"<td>"+this.description+"</td></tr>");
			});
		});
	});
</script>
</head>
<body>
	<h2>JSON 자료의 출력</h2>
	<table id="fruit" border="1">
	</table>
</body>
</html>