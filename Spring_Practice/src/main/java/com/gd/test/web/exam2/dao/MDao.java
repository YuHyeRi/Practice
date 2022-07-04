package com.gd.test.web.exam2.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MDao implements IMDao {
	
	@Autowired
	public SqlSession session;

	@Override
	public List<HashMap<String, String>> getListM(HashMap<String, String> params) throws Throwable {
		return session.selectList("m.getListM", params);
	}

	@Override
	public HashMap<String, String> getM(HashMap<String, String> params) throws Throwable {
		return session.selectOne("m.getM", params);
	}

	@Override
	public int addM(HashMap<String, String> params) throws Throwable {
		return session.insert("m.addM", params);
	}

	@Override
	public int updateM(HashMap<String, String> params) throws Throwable {
		return session.update("m.updateM", params);
	}

	@Override
	public int deleteM(HashMap<String, String> params) throws Throwable {
		return session.delete("m.deleteM", params);
	}

	@Override
	public int MCnt(HashMap<String, String> params) throws Throwable {
		return session.selectOne("m.MCnt", params);			// 앞에 int를 가져오니까 selectOne
	}

	@Override
	public int mIdCheck(HashMap<String, String> params) throws Throwable {
		return session.selectOne("m.mIdCheck", params);
	}

	@Override
	public HashMap<String, String> loginM(HashMap<String, String> params) throws Throwable {
		return session.selectOne("m.loginM", params);
	}
	
	
}	// end
