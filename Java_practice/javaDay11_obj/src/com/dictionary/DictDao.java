package com.dictionary;

import java.util.ArrayList;
import java.util.List;

public class DictDao {

	List<DictDto> list = new ArrayList<DictDto>();
	
	// 생성자
	public DictDao() {
		list.add(new DictDto("A", "에이"));
		list.add(new DictDto("B", "비"));
		list.add(new DictDto("C", "씨"));
		list.add(new DictDto("D", "디"));
	}
	
	public List<DictDto> getList(){
		return list;
	}
	
	public void insert(DictDto dto) {
		list.add(dto);
	}
	
}
