<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<!-- cos.jar -->
<%@ page import="com.oreilly.servlet.*" %>
<%@ page import="com.oreilly.servlet.multipart.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String upload_path = "c:/uploadTest";	// 파일을 업로드할 디렉토리를 미리 만들어두고 설정
	int size = 10*1024*1024;				// 파일 업로드 최대용량 (현재 10MB)
	String name = "";
	String subject = "";
	String filename = "";
	String filename2 = "";
	int filesize = 0;
	int filesize2 = 0;
	
	try {
		// MultipartRequest : '텍스트+파일' 같이 처리할 수 있음
		// DefaultFileRenamePolicy : 파일 이름 중복되면 파일이름+번호를 붙여서 중복되지 않게.. (ex.파일이름(1))
		// utf-8 : 파일 인코딩 형식
		MultipartRequest multi = new MultipartRequest(
				request, upload_path, size, "utf-8", 		
				new DefaultFileRenamePolicy());
		name = multi.getParameter("name");
		subject = multi.getParameter("subject");
		// Enumeration : 집합을 처리하는 객체(첨부파일 이름 집합)
		// Enumeration : 순서대로 저장되지는 않음!!
		Enumeration files = multi.getFileNames();
		String file1 = (String)files.nextElement();		// nextElement : 다음요소
		String file2 = (String)files.nextElement();
		
		filename = multi.getFilesystemName(file1);		// 파일이름
		File f1 = multi.getFile(file1);					// 파일 참조 변수
		filesize = (int)f1.length();	
		// 파일의 사이즈
		filename2 = multi.getFilesystemName(file2);
		File f2 = multi.getFile(file2);
		filesize2 = (int)f2.length();
	} catch (Exception e) {
		e.printStackTrace();
	}
	%>
	
	이름 : <%=name%><br>
	제목 : <%=subject%><br>
	파일1 이름 : <%=filename%><br>
	파일1 크기 : <%=filesize%><br>
	파일2 이름 : <%=filename2%><br>
	파일2 크기 : <%=filesize2%><br>
	
</body>
</html>