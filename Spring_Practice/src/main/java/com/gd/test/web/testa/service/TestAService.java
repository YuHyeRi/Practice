package com.gd.test.web.testa.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.test.web.testa.dao.ITestADao;

@Service
public class TestAService implements ITestAService {
	
	@Autowired
	public ITestADao iTestADao;

	@Override
	public int getABCnt(HashMap<String, String> params) throws Throwable {
		return iTestADao.getABCnt(params);
	}

	@Override
	public List<HashMap<String, String>> getABList(HashMap<String, String> params) throws Throwable {
		return iTestADao.getABList(params);
	}

	@Override
	public int abAdd(HashMap<String, String> params) throws Throwable {
		return iTestADao.abAdd(params);
	}

	@Override
	public HashMap<String, String> getAB(HashMap<String, String> params) throws Throwable {
		return iTestADao.getAB(params);
	}

	@Override
	public int abUpdate(HashMap<String, String> params) throws Throwable {
		return iTestADao.abUpdate(params);
	}

	@Override
	public int abDelete(HashMap<String, String> params) throws Throwable {
		return iTestADao.abDelete(params);
	}

	@Override
	public void updateABHit(HashMap<String, String> params) throws Throwable {
		iTestADao.updateABHit(params);
	}
	
	

}	// class end
