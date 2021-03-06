package com.gd.test.web.testa.service;

import java.util.HashMap;
import java.util.List;

public interface ITestAService {

	public int getABCnt(HashMap<String, String> params) throws Throwable;

	public List<HashMap<String, String>> getABList(HashMap<String, String> params) throws Throwable;

	public int abAdd(HashMap<String, String> params) throws Throwable;

	public HashMap<String, String> getAB(HashMap<String, String> params) throws Throwable;

	public int abUpdate(HashMap<String, String> params) throws Throwable;

	public int abDelete(HashMap<String, String> params) throws Throwable;

	public void updateABHit(HashMap<String, String> params) throws Throwable;


}
