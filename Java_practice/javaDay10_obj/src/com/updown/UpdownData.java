package com.updown;

import java.util.Scanner;

public class UpdownData {
	// ����
	int[] numbers = new int[4];		// ������ 4�� �����
	int[] updown = new int[4];		// 1.up 2.down 3.match
	int user, comp;
	int cnt = 0;
	boolean match = false;
	
	// ����
	public int[] getNumbers() {
		return numbers;}
	
	public int[] getUpdown() {
		return updown;}
	
	public int getComp() {
		return comp;}
	
	// �޼���
	public void start() {
		comp = (int)(Math.random()*10) + 1;
		
		Scanner sc = new Scanner(System.in);
		
		do {
		System.out.print("���� : ");
		user = sc.nextInt();
		numbers[cnt] = user;
		
		if(comp == numbers[cnt]) {
			match = true;
			updown[cnt] = 3;
		} else if(comp > numbers[cnt]) {
			System.out.println("�� ū ���� �Է��ϼ���.");
			updown[cnt] = 1;
		} else {
			System.out.println("�� ���� ���� �Է��ϼ���.");
			updown[cnt] = 2;
		} 
		cnt++;
		} while(match == false && cnt < 4);
		
		if(match) 
			System.out.printf("%d������ ����!\n", cnt);
		else 
			System.out.println("�����߼̽��ϴ� TT\n");
	}
	
}