package com.gd.test.web.exam3.service;

import java.util.HashMap;
import java.util.List;

public interface ITestMService {

	public int getMCnt(HashMap<String, String> params) throws Throwable;

	public List<HashMap<String, String>> getMList(HashMap<String, String> params) throws Throwable;

	public HashMap<String, String> getM(HashMap<String, String> params) throws Throwable;

	public int addTestM(HashMap<String, String> params) throws Throwable;

	public int updateTestM(HashMap<String, String> params) throws Throwable;

	public int delTestM(HashMap<String, String> params) throws Throwable;

	public int getM1IdCheck(HashMap<String, String> params) throws Throwable;


}
