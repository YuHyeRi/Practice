package com.score;

import java.util.ArrayList;
import java.util.List;

// Dao (Data Access Object) : �����Ϳ� �����ϴ� ��ü
// Dao�� �����ڰ� select(), insert(), update(), delete()�� ���� �����ڵ鿡 ���� 
// �������̽��� �̸� �����س������ν� �����Ϳ� ���� ó���� ������ �� �� �ֵ��� ����

public class ScoreDao {
	
	List<ScoreDto> list = new ArrayList<ScoreDto>();	// �����͸� ��Ƶα� ���� �÷��� ��ü����
	
	// ������
	public ScoreDao() {
		list.add(new ScoreDto("A", 300, 200, 200, 200));
		list.add(new ScoreDto("B", 180, 190, 190, 200));
		list.add(new ScoreDto("C", 150, 80, 40, 50));
	}

	// �����ڿ� ���� getter ����
	public List<ScoreDto> getList() {
		return list;
	}
	
	// insert �޼���
	void insert(ScoreDto dto) {
		list.add(dto);
	}
}
