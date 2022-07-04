package com.gd.test.web.test.service;

import java.util.HashMap;
import java.util.List;

public interface ITestService {

	// 자동으로 메소드 달아주면 해야할 것 ==> 1. public  2. 예외처리
	public List<HashMap<String, String>> getB1List(HashMap<String, String> params) throws Throwable;

	// 두번째부터는 public이 자동으로 붙으니 예외처리만 해주면 ok
	public HashMap<String, String> getB1(HashMap<String, String> params) throws Throwable;

	// 예외처리
	public int addB1(HashMap<String, String> params) throws Throwable;

	// 예외처리
	public int updateB1(HashMap<String, String> params) throws Throwable;

	// 예외처리
	public int deleteB1(HashMap<String, String> params) throws Throwable;

	// 예외처리
	public int getB1Cnt(HashMap<String, String> params) throws Throwable;

	
}
