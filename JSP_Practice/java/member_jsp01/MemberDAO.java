package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import config.DB;

public class MemberDAO {

	public String loginCheck(String userid, String passwd) {
		String name = null;
		Connection conn = null;				// DB 접속
		PreparedStatement pstmt = null;		// SQL 실행
		ResultSet rs = null;				// 레코드셋 탐색, select의 결과처리
		
		try {
			conn = DB.dbconn();				// DB 접속성공, DB커넥션 리턴
			String sql = "select name from member where userid=? and passwd=?";	// ?파라미터
			pstmt = conn.prepareStatement(sql);	// SQL 준비
			pstmt.setString(1, userid);		// 1번 물음표에 userid 입력
			pstmt.setString(2, passwd);		// 2번 물음표
			rs = pstmt.executeQuery();		// sql실행, 레코드셋의 시작번지값을 rs에 전달
			if(rs.next()) {					// 레코드가 존재하면
				name = rs.getString("name");// 이름을 저장, rs.get자료형("필드명")
			} 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {							// 마지막으로 실행되는 코드, rs => pstmt => conn 역순으로 닫음
			try {
				if(rs != null)				// rs가 null이 아니면 닫기
					rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			} try {
				if(pstmt != null)
					pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			} try {
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} return name;
	}
}
