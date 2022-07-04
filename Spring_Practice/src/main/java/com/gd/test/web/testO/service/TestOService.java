package com.gd.test.web.testO.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.test.web.testO.dao.ITestODao;

@Service
public class TestOService implements ITestOService {
	
	@Autowired
	public ITestODao iTestODao;

	@Override
	public List<HashMap<String, String>> listO(HashMap<String, String> params) throws Throwable {
		return iTestODao.listO(params);
	}

	@Override
	public int cntO(HashMap<String, String> params) throws Throwable {
		return iTestODao.cntO(params);
	}

	@Override
	public int addO(HashMap<String, String> params) throws Throwable {
		return iTestODao.addO(params);
	}

	@Override
	public int delO(HashMap<String, String> params) throws Throwable {
		return iTestODao.delO(params);
	}

	@Override
	public int updateO(HashMap<String, String> params) throws Throwable {
		return iTestODao.updateO(params);
	}





	
	
	
}	// class end
