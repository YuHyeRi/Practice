package com.gd.test.web.exam.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class YhrDao implements IYhrDao {
	
	@Autowired
	public SqlSession session;

	@Override
	public List<HashMap<String, String>> SELLList(HashMap<String, String> params) throws Throwable {
		return session.selectList("yhr.SELLList", params);
	}

	@Override
	public HashMap<String, String> SELL(HashMap<String, String> params) throws Throwable {
		return session.selectOne("yhr.SELL", params);
	}

	@Override
	public int addSELL(HashMap<String, String> params) throws Throwable {
		return session.insert("yhr.addSELL", params);
	}

	@Override
	public int updateSELL(HashMap<String, String> params) throws Throwable {
		return session.update("yhr.updateSELL", params);
	}

	@Override
	public int deleteSELL(HashMap<String, String> params) throws Throwable {
		return session.delete("yhr.deleteSELL", params);
	}

	@Override
	public int SELLCnt(HashMap<String, String> params) throws Throwable {
		return session.selectOne("yhr.SELLCnt", params);
	}

	

}	// class end
