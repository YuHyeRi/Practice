package com.gd.test.web.exam.service;

import java.util.HashMap;
import java.util.List;

public interface IYhrService {

	// public, 예외처리
	public List<HashMap<String, String>> SELLList(HashMap<String, String> params) throws Throwable;

	public HashMap<String, String> SELL(HashMap<String, String> params) throws Throwable;

	public int addSELL(HashMap<String, String> params) throws Throwable;

	public int updateSELL(HashMap<String, String> params) throws Throwable;

	public int deleteSELL(HashMap<String, String> params) throws Throwable;

	public int SELLCnt(HashMap<String, String> params) throws Throwable;

	
}
