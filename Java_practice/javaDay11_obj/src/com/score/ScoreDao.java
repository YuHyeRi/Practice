package com.score;

import java.util.ArrayList;
import java.util.List;

// Dao (Data Access Object) : 데이터에 접근하는 객체
// Dao는 개발자가 select(), insert(), update(), delete()와 같은 연산자들에 대한 
// 인터페이스를 미리 정의해놓음으로써 데이터에 대한 처리를 간단히 할 수 있도록 도움

public class ScoreDao {
	
	List<ScoreDto> list = new ArrayList<ScoreDto>();	// 데이터를 담아두기 위한 컬렉션 객체생성
	
	// 생성자
	public ScoreDao() {
		list.add(new ScoreDto("A", 300, 200, 200, 200));
		list.add(new ScoreDto("B", 180, 190, 190, 200));
		list.add(new ScoreDto("C", 150, 80, 40, 50));
	}

	// 생성자에 대한 getter 생성
	public List<ScoreDto> getList() {
		return list;
	}
	
	// insert 메서드
	void insert(ScoreDto dto) {
		list.add(dto);
	}
}
