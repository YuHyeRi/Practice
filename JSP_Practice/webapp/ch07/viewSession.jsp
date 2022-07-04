<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션보기</title>
</head>
<body>
	<%
	// Enumeration : 배열.. 여러개를 한꺼번에 전송시 사용 
	// 가능하면 Enumeration 대신 Iteration를 사용을 권장하고 있다.
	// hasMoreElements() : 읽어올 요소가 남아있는지 확인. 있으면 true, 없으면 false. Iterator의 hasNext()와 같음
	// nextElement() : 다음 요소를 읽어 옴. Iterator의 next()와 같음
	
	Enumeration<String> attr = session.getAttributeNames();	//session.getAttributeNames() : 세션변수 리스트
	out.println("<h3>" + "while문으로 출력" + "</h3>");
	while(attr.hasMoreElements()) {						// 다음요소가 있으면 true
		String key = attr.nextElement();				// 다음요소	
		Object value = session.getAttribute(key);		// /session.getAttribute("세션변수명") : 세션값 조회 
		out.println("세션변수명 : " + key + "<br>");
		out.println("세션값 : " + value + "<br>");
	}
	// (형변환)session.getAttribute
	String id = (String)session.getAttribute("id");
	String passwd = (String)session.getAttribute("passwd");
	int age = (Integer)session.getAttribute("age");				// 이렇게 쓸수도 있고 ==> 이왕이면 이렇게 써주는게 좋다
	// Object a = session.getAttribute("age");					// 이렇게 쓸수도 있다 (object를 쓰면 형변환 안해도 됨)
	double height = (Double)session.getAttribute("height");
	%>
	<h3>첫번째 출력</h3>
	아이디 : <%=id%><br>
	패스워드 : <%=passwd%><br>
	나이 : <%=age%><br>
	키 : <%=height%><br><br>
	
	<h3>두번째 출력</h3>
	아이디 : ${sessionScope.id }<br>
	패스워드 : ${sessionScope.passwd }<br>
	나이 : ${sessionScope.age }<br>
	키 : ${sessionScope.height }<br>
	
	<h2><a href = "deleteSession.jsp">세션삭제</a></h2>
</body>
</html>