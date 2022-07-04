package com.dictionary;

import java.util.List;
import java.util.Scanner;

public class DictController {
	
	DictDao dao = new DictDao();
	
	public void menuDisplay() {
		System.out.println("1. 전체출력");
		System.out.println("2. 검색");
		System.out.println("3. 입력");
		System.out.println("4. 수정");
		System.out.println("5. 삭제");
		System.out.println("0. 종료");
		System.out.println();
	}
	
	public void start() {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			menuDisplay();
			System.out.print("선택 : ");
			int sel = sc.nextInt();
			
			switch(sel){
				case 1 : output(); break;
				case 2 : search(); break;
				case 3 : append(); break;
				case 4 : modify(); break; 
				case 5 : delete(); break;
				case 0 :
						System.out.println("프로그램을 종료합니다.");
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
		System.out.print("찾을단어 : ");
		String key = sc.next();
		
		int pos = find(key);
		if(pos == -1) {
			System.out.println("찾으시는 단어가 없습니다.");
			return;
		} System.out.println("found it!");
		// System.out.printf("%s ===> %s\n", dao.getList().get(pos).getEng(),
		//									 dao.getList().get(pos).getKor());
		DictDto dto = dao.getList().get(pos);
		System.out.printf("%s ===> %s\n", dto.getEng(), dto.getKor());
	}
	
	// 앞전 score와는 좀 다르게 짜봄
	void append() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("영단어 : ");
		String eng = sc.next();
		System.out.println("한글 : ");
		String kor = sc.next();
		
		if(find(eng) != -1) {
			System.out.println("이미 있는 단어 입니다.");
			return;
		} DictDto dto = new DictDto(eng, kor);
		dao.insert(dto);
	}
	
	void modify() {
		Scanner sc = new Scanner(System.in);
		System.out.print("찾을단어 : ");
		String key = sc.next();
		
		int pos = find(key);
		if(pos == -1) {
			System.out.println("찾으시는 단어가 없습니다.");
			return;
		} System.out.println("found it!");
		DictDto dto = dao.getList().get(pos);
		
		System.out.print("단어 : ");
		dto.setEng(sc.next());
		System.out.println("뜻 : ");
		dto.setKor(sc.next());
	}
	
	void delete() {
		Scanner sc = new Scanner(System.in);
		System.out.print("찾을단어 : ");
		String key = sc.next();
		
		int pos = find(key);
		if(pos == -1) {
			System.out.println("찾으시는 단어가 없습니다.");
			return;
		} dao.getList().remove(pos);
		System.out.println("삭제성공!");
		
	}
}
