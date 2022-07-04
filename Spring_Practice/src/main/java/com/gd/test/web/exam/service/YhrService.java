package com.gd.test.web.exam.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.test.web.exam.dao.IYhrDao;

@Service
public class YhrService implements IYhrService {
	
	@Autowired
	public IYhrDao iYhrDao;

	@Override
	public List<HashMap<String, String>> SELLList(HashMap<String, String> params) throws Throwable {
		return iYhrDao.SELLList(params);
	}

	@Override
	public HashMap<String, String> SELL(HashMap<String, String> params) throws Throwable {
		return iYhrDao.SELL(params);
	}

	@Override
	public int addSELL(HashMap<String, String> params) throws Throwable {
		return iYhrDao.addSELL(params);
	}

	@Override
	public int updateSELL(HashMap<String, String> params) throws Throwable {
		return iYhrDao.updateSELL(params);
	}

	@Override
	public int deleteSELL(HashMap<String, String> params) throws Throwable {
		return iYhrDao.deleteSELL(params);
	}

	@Override
	public int SELLCnt(HashMap<String, String> params) throws Throwable {
		return iYhrDao.SELLCnt(params);
	}

	

}	// class end
