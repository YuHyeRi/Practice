<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html> 
<head> 
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> 

<form method="post">
부서이름 <input type="text" name="dname">
<input type="submit" value="확인">
</form>


<%@ page import="java.sql.*" %>  
<%  
String driver="com.mysql.cj.jdbc.Driver"; // jdbc:DBMS이름@호스트:포트/데이터베이스
String url="jdbc:mysql://localhost/mydb?useSSL=false&serverTimezone=Asia/Seoul"; //연결문자열
String id="user"; //아이디
String pwd="1234"; //비번

Connection conn=null;
PreparedStatement pstmt=null;
ResultSet rs=null;

try {
	Class.forName(driver);	// 드라이버 로딩
	conn=DriverManager.getConnection(url,id,pwd); // mysql 서버에 접속
	String sql=
"select e.deptno, dname, count(*), sum(sal), round(avg(sal)), max(sal), min(sal)"
+" from emp e, dept d " 
+" where e.deptno=d.deptno and dname=? " 	// ?에 부서이름 전달 (ex.경리팀)
+" group by e.deptno, dname";	
	System.out.println(sql);
	pstmt=conn.prepareStatement(sql);
	String name="";
	if(request.getParameter("dname")!=null){
		name=request.getParameter("dname");
	}
	pstmt.setString(1, name);
	rs=pstmt.executeQuery();
%>
<table border="1">
	<tr>  <!-- Table Row 테이블의 행 -->
		<td>부서코드</td> <!-- Table Division 테이블의 셀 --> 
		<td>부서이름</td>
		<td>직원수</td>
		<td>급여총액</td>
		<td>평균급여</td>
		<td>최대값</td>
		<td>최소값</td>
	</tr>
<%	
	while(rs.next()) { //1개의 레코드를 읽음, 내용이 있으면 true, 없으면 false
		int deptno=rs.getInt("deptno"); //  get자료형("필드명") or get자료형(인덱스)
		String dname=rs.getString("dname");
		int count=rs.getInt(3);
		int sum=rs.getInt(4);
		double avg=rs.getDouble(5);
		int max=rs.getInt(6);
		int min=rs.getInt(7);
%>
	<tr>
		<td><%=deptno%></td>  <!-- =변수 , 변수에 저장된 값을 웹브라우저에 출력 -->
		<td><%=dname%></td>
		<td><%=count%></td>
		<td><%=sum%></td>
		<td><%=avg%></td>
		<td><%=max%></td>
		<td><%=min%></td>
	</tr>
<%		
	}
} catch (Exception e) {
	e.printStackTrace();
} finally {
	try {
	// 참조변수가 rs가 가리키는 내용이 null이 아니면 close()
		if(rs!=null) rs.close();
	} catch (Exception e2) {
		e2.printStackTrace();
	}
	try {
		if(pstmt!=null) pstmt.close();
	} catch (Exception e2) {
		e2.printStackTrace();
	}
	try {
		if(conn!=null) conn.close();
	} catch (Exception e2) {
		e2.printStackTrace();
	}			
}
%>
</table>
</body>
</html>