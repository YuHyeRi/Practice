package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.DB;

public class MemberDAO {

	public List<MemberDTO> memberList() {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		Connection conn = null;			// db 접속
		PreparedStatement pstmt = null;	// sql 실행
		ResultSet rs = null;			// 결과셋 탐색
		try {
			conn = DB.dbConn();			// db접속
			// to_char(날짜형, 문자열형식)
			String sql = "select userid, passwd, name," 
						 + " to_char(reg_date,'yyyy-mm-dd') reg_date, address, tel"
						 + " from member" 
						 + " order by name";
			pstmt = conn.prepareStatement(sql);		// sql 실행준비
			rs = pstmt.executeQuery();				// sql 실행
			
			while(rs.next()) {						// 1개의 레코드를 읽음
				// 레코드의 필드값들
				String userid = rs.getString("userid");
				String passwd = rs.getString("passwd");
				String name = rs.getString("name");
				String reg_date = rs.getString("reg_date");
				String address = rs.getString("address");
				String tel = rs.getString("tel");
			
				MemberDTO dto = new MemberDTO(userid, passwd, name, reg_date, address, tel);	// dto에 저장
				list.add(dto);	// ArrayList에 dto 추가
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			} try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			} try {
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} return list;		// 리스트 리턴
	}
	
	public void insert(MemberDTO dto) {		// 컨트롤러의 dao.insert(dto);가 여기로 들어감 (41번째행)
		Connection conn = null;				// db 접속
		PreparedStatement pstmt = null;		// sql 실행
		try {								// DB는 반드시 예외처리를 해줘야함
			conn = DB.dbConn();				// 커넥션
			String sql = "insert into member (userid, passwd, name, address, tel)" 	// 필드
						+ "values (?,?,?,?,?)";										// 값(맵핑안됐으니 ?로 셋팅)
			pstmt = conn.prepareStatement(sql);		// sql 실행객체
			pstmt.setString(1, dto.getUserid());	// 1번 물음표에 들어갈 내용
			pstmt.setString(2, dto.getPasswd());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getAddress());
			pstmt.setString(5, dto.getTel());
			// select - executeQuery() 함수를 쓴다
			// select가 아닌 경우, executeUpdate() 함수를 쓴다
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {							// 항상 실행되는 
			try {
				if(pstmt != null)			// null이 아닐 경우에만, close 하라
					pstmt.close();			// close는 단독으로는(?) 못함, try-catch를 써야해서 쓴 것
			} catch (Exception e2) {
				e2.printStackTrace();
			} try {
				if(conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public MemberDTO memberDetail(String id) {		// 회원 상세정보
		MemberDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.dbConn();
			String sql = "select * from member where userid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);			// 1번 물음표에 id를 넣어라
			rs = pstmt.executeQuery();
			if(rs.next()) {					// 레코드가 한개이기때문에, while문 대신 if문
				dto = new MemberDTO();
				dto.setUserid(rs.getString("userid"));
				dto.setPasswd(rs.getString("passwd"));
				dto.setName(rs.getString("name"));
				dto.setAddress(rs.getString("address"));
				dto.setTel(rs.getString("tel"));
				dto.setReg_date(rs.getString("reg_date"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
		} return dto;
	}
	
	public void update(MemberDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.dbConn();
			String sql = "update member set passwd=?, name=?, address=?, tel=?" + "where userid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPasswd());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getAddress());
			pstmt.setString(4, dto.getTel());
			pstmt.setString(5, dto.getUserid());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
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
		}
	}
	
	public void delete(String userid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.dbConn();
			String sql = "delete from member where userid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.executeUpdate();
		} catch (Exception e) {			// try{...} catch(Exception e) {e.printStackTrace();}
			e.printStackTrace();		// 에러메시지의 발생 근원지를 찾아서 단계별로 에러를 출력한다
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();	
			} catch (Exception e2) {
				e2.printStackTrace();
			} try {
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
		
	public String login(MemberDTO dto) {
		String result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.dbConn();
			String sql = "select * from member where userid=? and passwd=?";	// id,pw 모두 다 맞아야 나오게(and)
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUserid());	// 1번 물음표에 들어갈 
			pstmt.setString(2, dto.getPasswd());	// 2번 물음표에 들어갈
			rs = pstmt.executeQuery();				// 쿼리실행
			if(rs.next()) {							// 데이터 하나 읽어서(레코드 1개를 읽음)
				result = rs.getString("name");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)
					rs.close();
			} catch(Exception e2) {
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
		} return result;
	}
	
	
	public String loginCheck(MemberDTO dto) {
		String result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.dbConn();
			String sql = "select * from member where userid=? and passwd=?";	// id,pw 모두 다 맞아야 나오게(and)
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUserid());	// 1번 물음표에 들어갈 
			pstmt.setString(2, dto.getPasswd());	// 2번 물음표에 들어갈
			rs = pstmt.executeQuery();				// 쿼리실행
			if(rs.next()) {							// 데이터 하나 읽어서(레코드 1개를 읽음)
				result = rs.getString("name") + "님 환영합니다!";
			} else {
				result = "로그인 실패!";
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)
					rs.close();
			} catch(Exception e2) {
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
		} return result;
	}
	
	public void insertCrypt(MemberDTO dto) {	
		Connection conn = null;			
		PreparedStatement pstmt = null;		
		try {								
			conn = DB.dbConn();
			String sql = "insert into member (userid, passwd, name)" 	
						+ "values (?,pack_encryption_decryption.func_encrypt(?),?)";	// 암호화 함수					
			pstmt = conn.prepareStatement(sql);		
			pstmt.setString(1, dto.getUserid());	
			pstmt.setString(2, dto.getPasswd());
			pstmt.setString(3, dto.getName());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {							
			try {
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
		}
	}
	
	public String loginCheckCrypt(MemberDTO dto) {
		String result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.dbConn();
			String sql = "select * from member where userid=? "
						+ "and passwd=pack_encryption_decryption.func_encrypt(?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUserid());	
			pstmt.setString(2, dto.getPasswd());	
			rs = pstmt.executeQuery();				
			if(rs.next()) {							
				result = rs.getString("name") + "님 환영합니다!";
			} else {
				result = "로그인 실패!";
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)
					rs.close();
			} catch(Exception e2) {
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
		} return result;
	}
	
	
	
	
	
	
}	