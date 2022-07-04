package guestbook;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import sqlmap.MybatisManager;

public class GuestBookDAO {
	// 방명록 리스트 메소드 (searchkey:검색옵션, search:검색키워드)
	public List<GuestBookDTO> getList(String searchkey, String search) {
		SqlSession session = MybatisManager.getInstance().openSession();	// mybatis 실행객체
		List<GuestBookDTO> list = null;
		if(searchkey.equals("name_content")) {	// 이름+내용으로 찾기
			list = session.selectList("guestbook.gbListAll", search);	// '네임스페이스.태그아이디'에서 네임스페이스는 생략 가능
		} else {								// 이름으로 찾기, 내용으로 찾기
			Map<String, Object> map = new HashMap<>();
			map.put("searchkey", searchkey);
			map.put("search", search);
			list = session.selectList("gbList", map);	// 위 두개를 hashmap으로 묶은 map으로 넣음
		}
		session.close();
		return list;
	}
	
	// 글 삽입저장 메소드
	public void gbInsert(GuestBookDTO dto) {
		SqlSession session = MybatisManager.getInstance().openSession();
		String content = dto.getContent();
		content = content.replace("<", "&lt");
		content = content.replace(">", "&gt");
		content = content.replace("\n", "<br>");
		content = content.replace("  ", "&nbsp;&nbsp;");
		dto.setContent(content);
		session.insert("gbInsert", dto);
		session.commit();	// insert, update, delete시 commit (mybatis는 오토커밋이 아님!)
		session.close();
	}
	
	// 비밀번호 확인 메소드 (idx:글번호, passwd:사용자가 입력한 비밀번호)
	public boolean passwdCheck(int idx, String passwd) {
		boolean result = false;
		SqlSession session = MybatisManager.getInstance().openSession();
		GuestBookDTO dto = new GuestBookDTO();
		dto.setIdx(idx);
		dto.setPasswd(passwd);
		int count = session.selectOne("passwdCheck", dto);
		result = count == 1? true:false;	// 패스워드가 맞으면 true
		session.close();
		return result;
	}
	
	// 방명록 상세내용 메소드 (idx:글번호)
	public GuestBookDTO gbDetail(int idx) {
		GuestBookDTO dto = new GuestBookDTO();
		SqlSession session = MybatisManager.getInstance().openSession();
		dto = session.selectOne("gbDetail", idx);
		session.close();
		return dto;
	}
	
	// 방명록(레코드) 수정 메소드
	public void gbUpdate(GuestBookDTO dto) {
		SqlSession session = MybatisManager.getInstance().openSession();
		session.update("gbUpdate", dto);
		session.commit();	// update니까 commit
		session.close();
	}
	
	// 방명록(레코드) 삭제 메소드
	public void gbDelete(int idx) {
		SqlSession session = MybatisManager.getInstance().openSession();
		session.delete("gbDelete", idx);
		session.commit();	// delete니까 commit
		session.close();
	}
	
	public int getCount(String searchkey, String search) {
		int count = 0;
		SqlSession session = MybatisManager.getInstance().openSession();
		if(searchkey.equals("name_content")) {
			count = session.selectOne("gbCountAll", search);
		} else {
			Map<String, Object> map = new HashMap<>();
			map.put("searchkey", searchkey);
			map.put("search", search);
			count = session.selectOne("gbCount", map);
		}
		session.close();
		return count;
	}
}
