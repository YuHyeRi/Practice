<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/script/jquery/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#goForm").submit();
	});
</script>
</head>
<body>
	<form action="testDtl" method="post" id="goForm">
		<input type="hidden" name="no" value="${param.no}"	/>
		<input type="hidden" name="searchGbn" value="${param.searchGbn}"/>
		<input type="hidden" name="searchTxt" value="${param.searchTxt}" />
		<input type="hidden" name="page" value="${param.page}" />
	</form>
</body>
</html>