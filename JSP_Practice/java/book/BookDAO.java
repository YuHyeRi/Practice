package book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.jsp.tagext.TryCatchFinally;
import javax.sql.DataSource;

import config.DB;

public class BookDAO {
	public static BookDAO dao;	// 싱글톤
	
	private BookDAO() {	}		// private 생성자
	
	public static BookDAO getDao() {
		if(dao == null) {
			dao = new BookDAO();
		} return dao;
	}
	
	public ArrayList<BookDTO> bookList() {
		ArrayList<BookDTO> list = new ArrayList<BookDTO>();
		Connection conn = null;				// db 접속개체
		PreparedStatement pstmt = null;		// sql 실행객체
		ResultSet rs = null;				// 레코드셋, 결과셋 탐색
		
		try {
			conn = DB.dbconn();					// db 접속
			String sql = "select * from book";	// sqp 실행객체 생성	
			pstmt = conn.prepareStatement(sql);	// sql 준비
			rs = pstmt.executeQuery();			// sql 실행, SQL실행 후 결과셋이 rs에 리턴
			
			while(rs.next()) {					// 결과셋.next() 다음 레코드가 있으면 true
				BookDTO dto = new BookDTO();
				dto.setId(rs.getInt("id"));
				dto.setTitle(rs.getString("title"));
				dto.setAuthor(rs.getString("author"));
				dto.setPrice(rs.getInt("price"));
				dto.setQty(rs.getInt("qty"));
				list.add(dto);					// ArrayList에 추가
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {								// 오픈한 역순으로 닫기
			// ResultSet => Statement => Connection
			try {
				if(rs != null)
					rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			} try {
				if(pstmt != null)
					pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			} try {
				if(conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} return list;
	}
}
