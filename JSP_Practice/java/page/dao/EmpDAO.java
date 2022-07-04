package page.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import page.dto.EmpDTO;
import sqlmap.MybatisManager;

public class EmpDAO {

	public List<EmpDTO> empList(int start, int end) {		// 해당 페이지의 리스트
		List<EmpDTO> items = null;
		SqlSession session = MybatisManager.getInstance().openSession();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
		items = session.selectList("emp.empList", map);
		return items;
	}
	public int empCount() {				// 전체 게시물(레코드) 갯수
		int count = 0;
		SqlSession session = null;
		try {
			session = MybatisManager.getInstance().openSession();
			count = session.selectOne("emp.empCount");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null)
				session.close();
		}
		return count;
	}
}
