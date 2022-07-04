<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="str" value="hello jsp" />
	1. 문자열의 길이 : ${fn:length(str)}<br>
	2. 키워드의 인덱스 : ${fn:indexOf(str, 'jsp')}<br>
	3. 문자열 변경 : ${fn:replace(str, 'jsp', 'java')}<br>
</body>
</html>