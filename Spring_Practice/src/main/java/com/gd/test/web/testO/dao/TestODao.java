package com.gd.test.web.testO.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestODao implements ITestODao {
	
	@Autowired
	public SqlSession session;

	@Override
	public List<HashMap<String, String>> listO(HashMap<String, String> params) throws Throwable {
		return session.selectList("o.listO", params);
	}

	@Override
	public int cntO(HashMap<String, String> params) throws Throwable {
		return session.selectOne("o.cntO", params);
	}

	@Override
	public int addO(HashMap<String, String> params) throws Throwable {
		return session.insert("o.addO", params);
	}

	@Override
	public int delO(HashMap<String, String> params) throws Throwable {
		return session.delete("o.delO", params);
	}

	@Override
	public int updateO(HashMap<String, String> params) throws Throwable {
		return session.update("o.updateO", params);
	}




	
	
	

}	// class end
