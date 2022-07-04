package com.gd.test.web.exam3.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestMDao implements ITestMDao {
	
	@Autowired
	public SqlSession session;

	@Override
	public int getMCnt(HashMap<String, String> params) throws Throwable {
		return session.selectOne("testM.getMCnt", params);
	}

	@Override
	public List<HashMap<String, String>> getMList(HashMap<String, String> params) throws Throwable {
		return session.selectList("testM.getMList", params);
	}

	@Override
	public HashMap<String, String> getM(HashMap<String, String> params) throws Throwable {
		return session.selectOne("testM.getM", params);
	}

	@Override
	public int addTestM(HashMap<String, String> params) throws Throwable {
		return session.insert("testM.addTestM", params);
	}

	@Override
	public int updateTestM(HashMap<String, String> params) throws Throwable {
		return session.update("testM.updateTestM", params);
	}

	@Override
	public int delTestM(HashMap<String, String> params) throws Throwable {
		return session.update("testM.delTestM", params);
	}

	@Override
	public int getM1IdCheck(HashMap<String, String> params) throws Throwable {
		return session.selectOne("testM.getM1IdCheck", params);
	}
	
	

}	// class end
