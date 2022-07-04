<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<style>
	a:link {text-decoration : none;}
	a:visited {text-decoration : none;}
	a:hover {text-decoration : underline; color : red;}
	a:active {text-decoration : none; color : yellow;}
</style>
</head>
<body>
	<table border="1" style="border-collapse:collapse; width:700px">
		<tr>
			<th>사번</th>
			<th>이름</th>
		</tr>
	<c:forEach var="row" items="${list}">
		<tr align="center">
			<td>${row.empno}</td>
			<td>${row.ename}</td>
		</tr>
	</c:forEach>	<!-- var:개별값 items 리스트 -->
		<tr align="center">
			<td colspan="2">
				<c:if test="${page.curPage > 1}">		<!-- curPage : 현재페이지 ==> 현재페이지가 1보다 크면 -->
					<a href="#" onclick="list('1')">[처음]</a>
				</c:if>
				<c:if test="${page.curBlock > 1}">		<!-- curBlock:10~20, 20~30, ... -->
					<a href="#" onclick="list('${page.prevPage}')">[이전]</a>
				</c:if>
				<!-- var:현재값 begin:시작 end:끝값 -->
				<c:forEach var="num" begin="${page.blockStart}" end="${page.blockEnd}">
					<!-- c:choose : 여러개 중에 한 가지 조건을 처리할 때 -->
					<c:choose>	
						<c:when test="${num == page.curPage}">
						<!-- 현재페이지면 -->
							<span style="color:red">${num}</span>
						</c:when>
					<c:otherwise> <!-- 현재 페이지가 아니면 -->
						<a href="#" onclick="list('${num}')">${num}</a>
					</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if test="${page.curBlock < page.totBlock}">
					<a href="#" onclick="list('${page.nextPage}')">[다음]</a>
				</c:if>
				<c:if test="${page.curPage < page.totPage}">
					<a href="#" onclick="list('${page.totPage}')">[끝]</a>
				</c:if>
				
	</table>
</body>
</html>