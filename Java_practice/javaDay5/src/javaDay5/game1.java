package javaDay5;

import java.util.Scanner;

public class game1 {
	// Math.random() �Լ�
	// ���� ���� �� ����
	public static void main(String[] args) {
		
		//int i;
		//for(i=0; i<=10; i++) {
			// System.out.println(Math.random());	// 0 ~ 1 ������ ������ �Ǽ� ���
			// System.out.println((int)(Math.random()*10));	// 0 ~ 9 ������ ������ ���� ���
			// System.out.println((int)(Math.random()*3+1));} 	// 1 ~ 3 ������ ������ ���� ���
			
		Scanner sc = new Scanner(System.in);
		
		int user;
		int comp;
		String winner;
		String replay;
		
		do {
		System.out.println("Game Start? (1����, 2����, 3��)");
		
		user = sc.nextInt();
		comp = (int)(Math.random()*3+1);
		
		if(comp == 1) {
			if(user == 2) {
				winner = "�̰���ϴ�:)";
			} else if(user == 3) {
				winner = "�����ϴ�TT";
			} else {
				winner = "���º�!";
			}
		} else if(comp == 2) {
			if(user == 3) {
				winner = "�̰���ϴ�:)";
			} else if(user == 1) {
				winner = "�����ϴ�TT";
			} else {
				winner = "���º�!";
			}
		} else {
			if(user == 1) {
				winner = "�̰���ϴ�:)";
			} else if(user == 2) {
				winner = "�����ϴ�TT";
			} else {
				winner = "���º�!";
			}
		}
		
		System.out.println("��� : " + winner);
		System.out.printf("����̳��� : %d, ��ǻ�Ͱ����� : %d\n", user, comp);
		
		System.out.println();
		
		System.out.println("������ �ٽ� �ϽǷ���?(Y/N)");
		replay = sc.next();
		} while(replay.equals("Y")||replay.equals("y"));
		System.out.println("Game Over");
		
		
	}
}
