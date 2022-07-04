package com.gd.test.web.exam2.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.test.util.Utils;
import com.gd.test.web.exam2.dao.IMDao;

@Service
public class MService implements IMService {
	
	@Autowired
	public IMDao iMDao;

	@Override
	public List<HashMap<String, String>> getListM(HashMap<String, String> params) throws Throwable {
		List<HashMap<String, String>> list = iMDao.getListM(params); 
		
		for(HashMap<String, String> data : list) {
			data.put("M_PW", Utils.decryptAES128(data.get("M_PW")));
		}
		
		return list;
	}

	@Override
	public HashMap<String, String> getM(HashMap<String, String> params) throws Throwable {
		return iMDao.getM(params);
	}

	@Override
	public int addM(HashMap<String, String> params) throws Throwable {
		return iMDao.addM(params);
	}

	@Override
	public int updateM(HashMap<String, String> params) throws Throwable {
		return iMDao.updateM(params);
	}

	@Override
	public int deleteM(HashMap<String, String> params) throws Throwable {
		return iMDao.deleteM(params);
	}

	@Override
	public int MCnt(HashMap<String, String> params) throws Throwable {
		return iMDao.MCnt(params);
	}

	@Override
	public int mIdCheck(HashMap<String, String> params) throws Throwable {
		return iMDao.mIdCheck(params);
	}

	@Override
	public HashMap<String, String> loginM(HashMap<String, String> params) throws Throwable {
		return iMDao.loginM(params);
	}
	
}	// end
