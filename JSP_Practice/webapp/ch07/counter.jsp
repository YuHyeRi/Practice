<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
<%@ page import="common.Util"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	// request.getCookies() : 쿠키배열
	// 쿠키는 String으로만 저장 가능 (but, session의 경우 모든 데이터타입 가능, 세션의 경우:시간제한이 필요할때(세션만료))
	String count = Util.getCookie(request.getCookies(), "count");	// 방문횟수
	int intCount = 0;
	Date date = new Date();
	long now_time = date.getTime();	// 현재시각 (out.println(now_time);)
	String visitTime = Util.getCookie(request.getCookies(),"visit_time");	// 최근방문시각
	long visit_time = 0;
	if(visitTime != null && !visitTime.equals("")) {	// 최근 방문기록이 있다면
		visit_time = Long.parseLong(visitTime);			// String을 숫자로 변환(쿠키는 스트링 값이니까)
	}
	if(count == null || count.equals("")) {				// 첫방문
		response.addCookie(new Cookie("count", "1"));	// 쿠키추가, 스트링만 저장 가능("")
		response.addCookie(new Cookie("visit_time", Long.toString(now_time)));
		out.println("첫 방문을 환영합니다.");
	} else {											// 기존 방문자
		long period = now_time - visit_time;			// 현재시각 - 기존방문시각
		out.println("현재 : " + now_time + "<br>");
		out.println("최근 : " + visit_time + "<br>");
		out.println("시차 : " + period + "<br>");
		intCount = Integer.parseInt(count);
		if(period > 3*1000) {							// 3초로 설정해둠, 3초에 한번씩 올라가게 설정해둠
			intCount++;									// 카운트 증가
			response.addCookie(new Cookie("count", Integer.toString(intCount)));	// 쿠키값 업데이트(쿠키이름이 같다면)
			response.addCookie(new Cookie("visit_time", Long.toString(now_time)));
		} 
		out.println("방문횟수 : " + intCount + "<br>");
		String counter = Integer.toString(intCount);	// int를 다시 String으로 변경
		for (int i = 0; i < counter.length(); i++) { 	// 글자수만큼
			String img = "<img src='../images/" + counter.charAt(i) + ".gif'>"; // charAt(i) : 글자 하나하나 뽑기
			out.println(img);
		}
	}
	%>
</body>
</html>