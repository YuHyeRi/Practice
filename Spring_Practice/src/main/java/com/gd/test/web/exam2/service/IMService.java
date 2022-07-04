package com.gd.test.web.exam2.service;

import java.util.HashMap;
import java.util.List;

public interface IMService {

	// public, 예외처리
	public List<HashMap<String, String>> getListM(HashMap<String, String> params) throws Throwable;

	public HashMap<String, String> getM(HashMap<String, String> params) throws Throwable;

	public int addM(HashMap<String, String> params) throws Throwable;

	public int updateM(HashMap<String, String> params) throws Throwable;

	public int deleteM(HashMap<String, String> params) throws Throwable;

	public int MCnt(HashMap<String, String> params) throws Throwable;

	public int mIdCheck(HashMap<String, String> params) throws Throwable;

	public HashMap<String, String> loginM(HashMap<String, String> params) throws Throwable;
	
}
