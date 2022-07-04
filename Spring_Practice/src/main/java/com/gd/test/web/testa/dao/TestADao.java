package com.gd.test.web.testa.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestADao implements ITestADao {
	
	@Autowired
	public SqlSession session;

	@Override
	public int getABCnt(HashMap<String, String> params) throws Throwable {
		return session.selectOne("testA.getABCnt", params);
	}

	@Override
	public List<HashMap<String, String>> getABList(HashMap<String, String> params) throws Throwable {
		return session.selectList("testA.getABList", params);
	}

	@Override
	public int abAdd(HashMap<String, String> params) throws Throwable {
		return session.insert("testA.abAdd", params);
	}

	@Override
	public HashMap<String, String> getAB(HashMap<String, String> params) throws Throwable {
		return session.selectOne("testA.getAB", params);
	}

	@Override
	public int abUpdate(HashMap<String, String> params) throws Throwable {
		return session.update("testA.abUpdate", params);
	}

	@Override
	public int abDelete(HashMap<String, String> params) throws Throwable {
		// delete를 쓰지 않음에 유의!! (요즘추세가 삭제를 안함)
		return session.update("testA.abDelete", params);
	}

	@Override
	public void updateABHit(HashMap<String, String> params) throws Throwable {
		// 조회수 수정이니까 update
		session.update("testA.updateABHit",params);
	}
	

}	// class end
