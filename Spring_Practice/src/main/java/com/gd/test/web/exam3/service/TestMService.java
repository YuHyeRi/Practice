package com.gd.test.web.exam3.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.test.web.exam3.dao.ITestMDao;

@Service
public class TestMService implements ITestMService {
	
	@Autowired
	public ITestMDao iTestMDao;

	@Override
	public int getMCnt(HashMap<String, String> params) throws Throwable {
		return iTestMDao.getMCnt(params);
	}

	@Override
	public List<HashMap<String, String>> getMList(HashMap<String, String> params) throws Throwable {
		return iTestMDao.getMList(params);
	}

	@Override
	public HashMap<String, String> getM(HashMap<String, String> params) throws Throwable {
		return iTestMDao.getM(params);
	}

	@Override
	public int addTestM(HashMap<String, String> params) throws Throwable {
		return iTestMDao.addTestM(params);
	}

	@Override
	public int updateTestM(HashMap<String, String> params) throws Throwable {
		return iTestMDao.updateTestM(params);
	}

	@Override
	public int delTestM(HashMap<String, String> params) throws Throwable {
		return iTestMDao.delTestM(params);
	}

	@Override
	public int getM1IdCheck(HashMap<String, String> params) throws Throwable {
		return iTestMDao.getM1IdCheck(params);
	}


}	// class end