package com.gd.test.web.test.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.test.web.test.dao.ITestDao;

@Service
public class TestService implements ITestService {

	@Autowired
	public ITestDao iTestdao;	
	
	// 리턴 수정
	@Override
	public List<HashMap<String, String>> getB1List(HashMap<String, String> params) throws Throwable {
		return iTestdao.getB1List(params);
	}

	@Override
	public HashMap<String, String> getB1(HashMap<String, String> params) throws Throwable {
		return iTestdao.getB1(params);
	}

	@Override
	public int addB1(HashMap<String, String> params) throws Throwable {
		return iTestdao.addB1(params);
	}

	@Override
	public int updateB1(HashMap<String, String> params) throws Throwable {
		return iTestdao.updateB1(params);
	}

	@Override
	public int deleteB1(HashMap<String, String> params) throws Throwable {
		return iTestdao.deleteB1(params);
	}

	@Override
	public int getB1Cnt(HashMap<String, String> params) throws Throwable {
		return iTestdao.getB1Cnt(params);
	}
	
	

}
