<!-- ## search.jsp와 list.jsp는 완전히 똑같다 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(function(){
		$("#btnWrite").click(function() { 			// 글쓰기 버튼을 누르면
			location.href = "/jsp02/board/write.jsp"; // 쓰기 페이지로 이동
   });
});
	function list(page){
  	 location.href = "/jsp02/board_servlet/list.do?curPage="+page+"&search_option=${search_option}&keyword=${keyword}";
}
</script>
</head>
<body>
	<h2>게시판</h2>
	<form name="form1" method="post" action="/jsp02/board_servlet/search.do">
	<select name="search_option"> <!-- 검색옵션 -->
	<c:choose>
		<c:when test="${search_option == null || search_option == 'all' }">
			<option value="all" selected>전체검색</option>
			<option value="writer">이름</option>
			<option value="subject">제목</option>
			<option value="content">내용</option>
   		</c:when>
  		<c:when test="${search_option == 'writer'}">
      		<option value="all">전체검색</option>
      		<option value="writer" selected>이름</option>
     		 <option value="subject">제목</option>
      		<option value="content">내용</option>
  		</c:when>
   		<c:when test="${search_option == 'subject'}">
      		<option value="all">전체검색</option>
      		<option value="writer">이름</option>
     		<option value="subject" selected>제목</option>
      		<option value="content">내용</option>
   		</c:when>
   		<c:when test="${search_option == 'content'}">
      		<option value="all">전체검색</option>
      		<option value="writer">이름</option>
      		<option value="subject">제목</option>
      		<option value="content" selected>내용</option>
   		</c:when>
	</c:choose>
	</select>
		<input name="keyword" value="${keyword}"> <!-- 검색키워드 -->
		<input type="submit" value="검색" id="btnSearch">
		<button type="button" id="btnWrite">글쓰기</button>
	</form>
	
	<table border="1" width="900px">
  	<tr>
      <th>번호</th>
      <th>이름</th>
      <th>제목</th>
      <th>날짜</th>
      <th>조회수</th>
      <th>첨부파일</th>
      <th>다운로드</th>
   </tr>
	<!-- var 개별행 items 리스트 -->   
	<c:forEach var="dto" items="${list}">
   <tr>
      <td>${dto.num}</td>
      <td>${dto.writer}</td>
      <td align="left">
         <!--  &nbsp;&nbsp; : 답변 단계에 따라 들여쓰기  -->
         <c:forEach var="i" begin="1" end="${dto.re_level}">
            &nbsp;&nbsp;
         </c:forEach>
         <!-- 답변이면 Re: 표시 -->
         <c:if test="${dto.re_level > 0 }">Re:</c:if>
        	 <a href="/jsp02/board_servlet/view.do?num=${dto.num}">${dto.subject}</a>
         <!-- 댓글 개수 표시 -->
         <c:if test="${dto.comment_count > 0 }">
            <span style="color:green">(${dto.comment_count})</span>
         </c:if>
      </td>
      <td>${dto.reg_date}</td>
      <td>${dto.readcount}</td>
      <td align="center">
         <!-- 첨부파일이 있으면 -->
         <c:if test="${dto.filesize > 0 }">
            <a href="/jsp02/board_servlet/download.do?num=${dto.num}"><img src="/jsp02/images/file.png" 
            width="20" heigth="20"></a>
         </c:if>
      </td>
      <td>${dto.down}</td>
	</tr>
	</c:forEach>
	<tr align="center">
      <td colspan="7">
         <c:if test="${page.curBlock > 1 }">
            <a href="javascript:list('1')">[처음]</a>
         </c:if>
         <c:if test="${page.curBlock > 1 }">
            <a href="javascript:list('${page.prevPage}')">[이전]</a>
         </c:if>
         <c:forEach var="num" begin="${page.blockStart}" end="${page.blockEnd}">
            <c:choose>
               <c:when test="${num == page.curPage}">
                  <span style="color:red">${num}</span>
               </c:when>
               <c:otherwise>
                  <a href="list('${num}')">${num}</a>
               </c:otherwise>
            </c:choose>
         </c:forEach>
         <c:if test="${page.curBlock < page.totBlock }">
            <a href="javascript:list('${page.nextPage}')">[다음]</a>
         </c:if>
         <c:if test="${page.curPage < page.totPage }">
            <a href="javascript:list('${page.totPage}')">[끝]</a>
         </c:if>         
      </td>
	</tr>   
	</table>
</body>
</html>