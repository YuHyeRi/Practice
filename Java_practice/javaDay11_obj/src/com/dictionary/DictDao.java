package com.dictionary;

import java.util.ArrayList;
import java.util.List;

public class DictDao {

	List<DictDto> list = new ArrayList<DictDto>();
	
	// ������
	public DictDao() {
		list.add(new DictDto("A", "����"));
		list.add(new DictDto("B", "��"));
		list.add(new DictDto("C", "��"));
		list.add(new DictDto("D", "��"));
	}
	
	public List<DictDto> getList(){
		return list;
	}
	
	public void insert(DictDto dto) {
		list.add(dto);
	}
	
}
