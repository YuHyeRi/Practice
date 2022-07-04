package com.score;

import java.util.List;
import java.util.Scanner;

public class ScoreController {

	// 1. ScoreDao Ŭ���� ��ü ����
	ScoreDao dao = new ScoreDao();
	
	// 2. getScore �޼ҵ� --> �Ű����� 2��(�����, ���� ����(�갡 �ٸ�))
	public int getScore(String subject, int perfectScore) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print(subject + " : ");
		int score = sc.nextInt();
		
		while(score<0 || score>perfectScore) {
			System.out.printf("error! �Է¹��� �ʰ�(0~%d������ ���� �Է�)\n", perfectScore);
			System.out.println(subject + " : ");
			score = sc.nextInt();
		} return score;
	}
	
	// 3. display �޼ҵ�
	public void display() {
		System.out.println("1. ��ü���");
		System.out.println("2. �˻�");
		System.out.println("3. �߰�");
		System.out.println("4. ����");
		System.out.println("5. ����");
		System.out.println("0. ����");
		System.out.println();
	}
	
	// 4. start �޼ҵ� (����޼ҵ�)
	public void start() {
		Scanner sc = new Scanner(System.in);
		
		while(true) {	// ���ѷ���
		display();
		System.out.print("���� : ");
		int sel = sc.nextInt();
		
		switch(sel) {
		case 1 : output(); break;
		case 2 : search(); break;
		case 3 : append(); break;
		case 4 : modify(); break;
		case 5 : delete(); break;
		case 0 : System.out.println("���α׷��� ����Ǿ����ϴ�!"); 
				 return;		// �Լ����� (cf. break;�� switch�� ��������, while ����X)
			}
		}
	}
	
	// 5. output �޼ҵ�
	public void output() {
		List<ScoreDto> list = dao.getList();
		for(int i=0; i<list.size(); i++) {
			list.get(i).process();
			list.get(i).output();
		}
	}
	
	
	// 6. find �޼ҵ�
	// Ư�������� ��ġ�� ã�Ƽ� ��ȯ�ϴ� �Լ��� ����
	int find(String name) {
		for(int i=0; i<dao.getList().size(); i++) {
			ScoreDto dto = dao.getList().get(i);
			if(dto.getName().equals(name))
				return i;
		} return -1;	// �Լ��� �������� int�� ���, ���� �߻��� ���� -1�� ������
	}					// ���� : ����������, �������, �Լ����� ����� ������ ���� ��..
	
	// 7. search �޼ҵ�
	public void search() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�̸� : ");
		String name = sc.next();
		
		int pos = find(name);	// ��ġ���� ��ȯ����
		if(pos == -1) {
			System.out.println(name + "�� ã�� �� �����ϴ�.");
			return;
		} ScoreDto dto = dao.getList().get(pos);
		dto.output();
	} 
	
	// 8. append �޼ҵ�
	public void append() {
		Scanner sc = new Scanner(System.in);
		
		ScoreDto dto = new ScoreDto();
		System.out.print("�̸� : ");
		dto.setName(sc.next());
		dto.setWrite(getScore("�ʱ�", 400));		// �Լ��� �Լ� ȣ���ϱ�(�����Լ���������)
		dto.setWord(getScore("����", 200));
		dto.setPpt(getScore("PPT", 200));
		dto.setExcel(getScore("Excel", 200));
		dao.getList().add(dto);
	}
	
	// 9. modify �޼ҵ�
	public void modify() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("������ �̸� : ");
		String name = sc.next();
		
		int pos = find(name);
		if(pos == -1) {
			System.out.println(name + "�� ã�� �� �����ϴ�.");
			return;
		} ScoreDto dto = dao.getList().get(pos);	// ���θ����� �ʰ� ������ü�� ���
		System.out.print("�̸� : ");
		dto.setName(sc.next());
		dto.setWrite(getScore("�ʱ�", 400));
		dto.setWord(getScore("����", 200));
		dto.setPpt(getScore("PPT", 200));
		dto.setExcel(getScore("Excel", 200));
	}
	
	// 10. delete �޼ҵ�
	public void delete() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("������ �̸� : ");
		String name = sc.next();
		
		int pos = find(name);
		if(pos == -1) {
			System.out.println(name + "�� ã�� �� �����ϴ�.");
			return;
		} ScoreDto dto = dao.getList().get(pos);
		dao.getList().remove(pos);
		System.out.println("��������!");
	}
}
