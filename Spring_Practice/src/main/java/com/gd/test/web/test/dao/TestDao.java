package com.gd.test.web.test.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository	
public class TestDao implements ITestDao {
	
	@Autowired
	public SqlSession sqlSession;		// DB와 연결할 준비 완료

	// 리턴 수정
	@Override
	public List<HashMap<String, String>> getB1List(HashMap<String, String> params) throws Throwable {
		// selectList("네임스페이스아이디.셀렉트문아이디")
		// select한 쿼리문은 여러줄이니까 list로 받음
		return sqlSession.selectList("test.getB1List", params);		// 실행 쿼리 결과를 params으로 받음
	}

	@Override
	public HashMap<String, String> getB1(HashMap<String, String> params) throws Throwable {
		// selectOne : 한 줄의 row만 받으니까 one으로 받음
		return sqlSession.selectOne("test.getB1", params);
	}

	@Override
	public int addB1(HashMap<String, String> params) throws Throwable {
		// 몇 건 실행했는지 건수만 돌려줌
		return sqlSession.insert("test.addB1", params);
	}

	@Override
	public int updateB1(HashMap<String, String> params) throws Throwable {
		// 몇 건 실행했는지 건수만 돌려줌
		return sqlSession.update("test.updateB1", params);
	}

	@Override
	public int deleteB1(HashMap<String, String> params) throws Throwable {
		// 몇 건 실행했는지 건수만 돌려줌
		return sqlSession.delete("test.deleteB1", params);
	}

	@Override
	public int getB1Cnt(HashMap<String, String> params) throws Throwable {
		// 총 게시물(데이터) 갯수 -> cnt 건수 하나만 돌려줌
		return sqlSession.selectOne("test.getB1Cnt", params);
	}

	
	
}
