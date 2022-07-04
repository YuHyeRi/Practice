package com.addressbook;

import java.util.List;
import java.util.Scanner;

public class AddressBookController {
	
	AddressBookDao dao = new AddressBookDao();
	
	public void display() {
		System.out.println("1. 전체출력");
		System.out.println("2. 검색");
		System.out.println("3. 추가");
		System.out.println("4. 수정");
		System.out.println("5. 삭제");
		System.out.println("0. 종료");
		System.out.println();
	}
	
	public void start() {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			display();
			System.out.print("선택 : ");
			int sel = sc.nextInt();
			
			switch(sel) {
			case 1 : output(); break;
			case 2 : search(); break;
			case 3 : append(); break;
			case 4 : modify(); break;
			case 5 : delete(); break;
			case 0 :
					System.out.println("=== 프로그램 종료 ===");
					return;
			}
		}
	}
	
	void output() {
		List<AddressBookDto> list = dao.getList();
		for(int i=0; i<list.size(); i++) {
			AddressBookDto dto = list.get(i);
			System.out.printf("%s - %s - %s\n", dto.getName(), dto.getEmail(), dto.getPhone());
		}
	}
	
	int find(String key) {
		List<AddressBookDto> list = dao.getList();
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getName().equals(key)) {
				return i;
			}
		} return -1;
	}
	
	void search() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("검색할 이름을 입력하세요 : ");
		String key = sc.next();
		
		int pos = find(key);
		if(pos == -1) {
			System.out.println("!!empty!!");
			return;
		} System.out.println("찾았습니다!");
		AddressBookDto dto = dao.getList().get(pos);
		System.out.printf("%s - %s - %s\n", dto.getName(), dto.getEmail(), dto.getPhone());
	}
	
	void append() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("이름 : ");
		String name = sc.next();
		System.out.println("이메일주소 : ");
		String email = sc.next();
		System.out.println("연락처 : ");
		String phone = sc.next();
		
		if(find(name) != -1) {
			System.out.println("해당 내용이 이미 존재합니다.");
			return;
		} AddressBookDto dto = new AddressBookDto(name, email, phone);
		dao.insert(dto);
	}
	
	void modify() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("수정할 이름 입력 : ");
		String key = sc.next();
		
		int pos = find(key);
		if(pos == -1) {
			System.out.println("!!empty!!");
			return;
		} System.out.println("찾았습니다!");
		
		AddressBookDto dto = dao.getList().get(pos);
		
		System.out.println("이름 : ");
		dto.setName(sc.next());
		System.out.println("이메일주소 : ");
		dto.setEmail(sc.next());
		System.out.println("연락처 : ");
		dto.setPhone(sc.next());
	}
	
	void delete() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("삭제할 이름을 입력하세요.");
		String key = sc.next();
		
		int pos = find(key);
		if(pos == -1) {
			System.out.println("!!empty!!");
			return;
		} dao.getList().remove(pos);
		System.out.println("삭제성공!");
	}

}
