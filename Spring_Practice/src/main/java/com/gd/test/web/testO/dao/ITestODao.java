package com.gd.test.web.testO.dao;

import java.util.HashMap;
import java.util.List;

public interface ITestODao {

	public List<HashMap<String, String>> listO(HashMap<String, String> params) throws Throwable;

	public int cntO(HashMap<String, String> params) throws Throwable;

	public int addO(HashMap<String, String> params) throws Throwable;

	public int delO(HashMap<String, String> params) throws Throwable;

	public int updateO(HashMap<String, String> params) throws Throwable;








}
