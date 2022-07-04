package com.dictionary;

import java.util.List;
import java.util.Scanner;

public class DictController {
	
	DictDao dao = new DictDao();
	
	public void menuDisplay() {
		System.out.println("1. ��ü���");
		System.out.println("2. �˻�");
		System.out.println("3. �Է�");
		System.out.println("4. ����");
		System.out.println("5. ����");
		System.out.println("0. ����");
		System.out.println();
	}
	
	public void start() {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			menuDisplay();
			System.out.print("���� : ");
			int sel = sc.nextInt();
			
			switch(sel){
				case 1 : output(); break;
				case 2 : search(); break;
				case 3 : append(); break;
				case 4 : modify(); break; 
				case 5 : delete(); break;
				case 0 :
						System.out.println("���α׷��� �����մϴ�.");
						return;
			}
		}
	}
	
	void output() {
		List<DictDto> list = dao.getList();
		for(int i=0; i<list.size(); i++) {
			DictDto dto = list.get(i);
			System.out.printf("%s ====> %s\n", dto.getEng(), dto.getKor());
		}
	}
	
	int find(String key) {
		List<DictDto> list = dao.getList();
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getEng().equals(key) || list.get(i).getKor().equals(key)) {
				return i;
			}
		} return -1;
	}
	
	void search() {
		Scanner sc = new Scanner(System.in);
		System.out.print("ã���ܾ� : ");
		String key = sc.next();
		
		int pos = find(key);
		if(pos == -1) {
			System.out.println("ã���ô� �ܾ �����ϴ�.");
			return;
		} System.out.println("found it!");
		// System.out.printf("%s ===> %s\n", dao.getList().get(pos).getEng(),
		//									 dao.getList().get(pos).getKor());
		DictDto dto = dao.getList().get(pos);
		System.out.printf("%s ===> %s\n", dto.getEng(), dto.getKor());
	}
	
	// ���� score�ʹ� �� �ٸ��� ¥��
	void append() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("���ܾ� : ");
		String eng = sc.next();
		System.out.println("�ѱ� : ");
		String kor = sc.next();
		
		if(find(eng) != -1) {
			System.out.println("�̹� �ִ� �ܾ� �Դϴ�.");
			return;
		} DictDto dto = new DictDto(eng, kor);
		dao.insert(dto);
	}
	
	void modify() {
		Scanner sc = new Scanner(System.in);
		System.out.print("ã���ܾ� : ");
		String key = sc.next();
		
		int pos = find(key);
		if(pos == -1) {
			System.out.println("ã���ô� �ܾ �����ϴ�.");
			return;
		} System.out.println("found it!");
		DictDto dto = dao.getList().get(pos);
		
		System.out.print("�ܾ� : ");
		dto.setEng(sc.next());
		System.out.println("�� : ");
		dto.setKor(sc.next());
	}
	
	void delete() {
		Scanner sc = new Scanner(System.in);
		System.out.print("ã���ܾ� : ");
		String key = sc.next();
		
		int pos = find(key);
		if(pos == -1) {
			System.out.println("ã���ô� �ܾ �����ϴ�.");
			return;
		} dao.getList().remove(pos);
		System.out.println("��������!");
		
	}
}
