package emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import config.DB;

public class EmpDAO {
	
	public void insert() {
		Connection conn = null;				// db 접속
		PreparedStatement pstmt = null;		// sql 실행
		
		try {
			conn = DB.dbConn();
			// 오토커밋을 수동으로 하는 이유가 10만 건중에 예를 들어 5만건에서 오류가 났을경우, 롤백해주기 위한 것
			conn.setAutoCommit(false);		// auto commit 해제 (java는 디폴트값이 auto commit)
			// System.currentTimeMillis(); : 시스템의 현재시각을 숫자로 저장
			long before = System.currentTimeMillis();	// 실행 전의 시간 측정
			for(int i=1; i<=100000; i++) {
				String sql = "insert into emp2 (empno, ename, deptno) values(?,?,?)";
				pstmt = conn.prepareStatement(sql);		// sql 실행객체
				pstmt.setInt(1, i);						// 1번 물음표
				pstmt.setString(2, "kim" + i);			// 2번 물음표
				pstmt.setInt(3, i);						// 3번 물음표
				pstmt.executeUpdate();					// 레코드 추가(update)
				pstmt.close();							// sql 실행객체 종료
			} 
			long after = System.currentTimeMillis();	// 실행 후의 시간 측정
			conn.commit();
			conn.setAutoCommit(true);
			System.out.println("실행시간 : " + (after - before));	// 밀리세컨드
		} catch (Exception e) {							// 에러 발생시
			e.printStackTrace();
			try {
				if(conn != null)
					conn.rollback();					// 롤백
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} finally {
			try {
				if(pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void insert_batch() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DB.dbConn();
			conn.setAutoCommit(false);
			String sql = "insert into emp2 (empno, ename, deptno) values (?,?,?)";
			pstmt = conn.prepareStatement(sql);	// 위 메소드와 위치가 다름 (한번만 실행 => 처리속도 빨라지고 비용도 낮아짐)
			long before = System.currentTimeMillis();
			for(int i=100001; i<=200000; i++) {
				pstmt.setInt(1, i);
				pstmt.setString(2, "kim" + i);
				pstmt.setInt(3, i);
				pstmt.addBatch();				// 배치작업(일괄처리) 추가 (ex. 10만건을 예약만 걸어놓고)
			}
			pstmt.executeBatch();				// 10만건을 한꺼번에 입력 (ex. 마지막에 한번에 실행함)
			conn.commit();
			conn.setAutoCommit(true);
			long after = System.currentTimeMillis();
			System.out.println("실행시간 : " + (after - before));
		} catch (Exception e) {
			e.printStackTrace();
			try {
				if(conn != null)
					conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} finally {
			try {
				if(pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
} // class


