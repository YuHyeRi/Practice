<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="book.*" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% BookDAO dao = BookDAO.getDao();
	   ArrayList<BookDTO> list = dao.bookList();
	%>
	<ul>
	<% for(BookDTO dto : list) { %>		<!-- for(개별데이터 : 리스트) -->
		<li>
		<%=dto.getTitle()%>
		( <%=dto.getPrice() + "원"%> )
		</li>
	<% } %>

</body>
</html>