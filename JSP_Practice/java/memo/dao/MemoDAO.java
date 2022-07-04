package memo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import memo.dto.MemoDTO;
import sqlmap.MybatisManager;

public class MemoDAO {
	
	public List<MemoDTO> listMemo(String searchkey, String search) {	//searchkey:검색옵션, search:검색키워드
		SqlSession session = MybatisManager.getInstance().openSession();
		List<MemoDTO> list = null;
		if (searchkey.equals("writer_memo")) {
			list = session.selectList("memo.listAll", search);	// selectList("네임스페이스.아이디",전달할값) : 레코드 2개 이상 셀렉
		} else {
			Map<String, Object> map = new HashMap<>();
			map.put("searchkey", searchkey);
			map.put("search", search);
			System.out.println(map);
			list = session.selectList("memo.list", map);
		}
		session.close();
		return list;
	}
	
	public void insertMemo(MemoDTO dto) {
		SqlSession session = MybatisManager.getInstance().openSession();
		
		// 2칸 이상 공백도 허용하게
		String memo=dto.getMemo();
		memo = memo.replace("  ", "&nbsp;&nbsp;");	// 공백 2개를 변환
		
		// 태그 문자 처리
		memo = memo.replace("<", "&lt;");
		memo = memo.replace(">", "&gt;");
		dto.setMemo(memo);
		session.insert("memo.insert", dto);
		// mybatis는 기본적으로 오토커밋이 아니기때문에, 커밋해줘야함
		session.commit();
		session.close();
	}
	
	public MemoDTO viewMemo(int idx) {
		SqlSession session = MybatisManager.getInstance().openSession();
		MemoDTO dto = session.selectOne("memo.view", idx);
		session.close();
		return dto;
	}
	
	public void updateMemo(MemoDTO dto) {
		SqlSession session = MybatisManager.getInstance().openSession();
		session.update("memo.update", dto);
		session.commit();
		session.close();
	}
	
	public void deleteMemo(int idx) {
		SqlSession session = MybatisManager.getInstance().openSession();
		session.delete("memo.delete", idx);
		session.commit();
		session.close();
	}
								
	public int countMemo(String searchkey, String search) {
		int count = 0;
		SqlSession session = MybatisManager.getInstance().openSession();
		if (searchkey.equals("writer_memo")) {
			count = session.selectOne("memo.countAll", search);
		} else {
			Map<String, Object> map = new HashMap<>();
			map.put("searchkey", searchkey);
			map.put("search", search);
			count = session.selectOne("memo.count", map);
		}
		session.close();
		return count;
	}
}
