package com.addressbook;

import java.util.List;
import java.util.Scanner;

public class AddressBookController {
	
	AddressBookDao dao = new AddressBookDao();
	
	public void display() {
		System.out.println("1. ��ü���");
		System.out.println("2. �˻�");
		System.out.println("3. �߰�");
		System.out.println("4. ����");
		System.out.println("5. ����");
		System.out.println("0. ����");
		System.out.println();
	}
	
	public void start() {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			display();
			System.out.print("���� : ");
			int sel = sc.nextInt();
			
			switch(sel) {
			case 1 : output(); break;
			case 2 : search(); break;
			case 3 : append(); break;
			case 4 : modify(); break;
			case 5 : delete(); break;
			case 0 :
					System.out.println("=== ���α׷� ���� ===");
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
		
		System.out.print("�˻��� �̸��� �Է��ϼ��� : ");
		String key = sc.next();
		
		int pos = find(key);
		if(pos == -1) {
			System.out.println("!!empty!!");
			return;
		} System.out.println("ã�ҽ��ϴ�!");
		AddressBookDto dto = dao.getList().get(pos);
		System.out.printf("%s - %s - %s\n", dto.getName(), dto.getEmail(), dto.getPhone());
	}
	
	void append() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�̸� : ");
		String name = sc.next();
		System.out.println("�̸����ּ� : ");
		String email = sc.next();
		System.out.println("����ó : ");
		String phone = sc.next();
		
		if(find(name) != -1) {
			System.out.println("�ش� ������ �̹� �����մϴ�.");
			return;
		} AddressBookDto dto = new AddressBookDto(name, email, phone);
		dao.insert(dto);
	}
	
	void modify() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("������ �̸� �Է� : ");
		String key = sc.next();
		
		int pos = find(key);
		if(pos == -1) {
			System.out.println("!!empty!!");
			return;
		} System.out.println("ã�ҽ��ϴ�!");
		
		AddressBookDto dto = dao.getList().get(pos);
		
		System.out.println("�̸� : ");
		dto.setName(sc.next());
		System.out.println("�̸����ּ� : ");
		dto.setEmail(sc.next());
		System.out.println("����ó : ");
		dto.setPhone(sc.next());
	}
	
	void delete() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("������ �̸��� �Է��ϼ���.");
		String key = sc.next();
		
		int pos = find(key);
		if(pos == -1) {
			System.out.println("!!empty!!");
			return;
		} dao.getList().remove(pos);
		System.out.println("��������!");
	}

}
