package com.updown;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UpdownGame {
	// List�� �θ�Ŭ���� -> ��ӹ޾Ƽ� ArrayList�� ���������.
	// <> : ���⿡ ���� ���� ����, ���� ��쿡�� UpdownData�̶�� class�� ���� ��.
	List<UpdownData> list = new ArrayList<UpdownData>();
	
	// ���� ������ ���� �Լ��� ���� ��쵵 ����
	public void start() {
		int again;
		do {
			UpdownData u1 = new UpdownData();
			u1.start();		// ���� ���� ������
			list.add(u1);	// �� ���ӿ� ���� ������ �����ؼ� list�� ����
			
			Scanner sc = new Scanner(System.in);
			System.out.println();
			System.out.println("������ �ٽ� �ұ��? 1.��  2.�ƴϿ�");
			again = sc.nextInt();
		} while(again == 1);
		output();
	}
	
	// �޼���
	public void output() {
		for(int i=0; i<list.size(); i++) {
			UpdownData u1 = list.get(i);	// ����� ������ ��������
			System.out.printf("��ǻ�� : %d\n", u1.getComp());
			
			for(int j=0; j<u1.getNumbers().length; j++)
				System.out.printf("%4d", u1.getNumbers()[j]);	// ����ڰ� ���ݱ��� �Է��� ���� ���
			System.out.println();
			for(int k=0; k<u1.getUpdown().length; k++)
				System.out.printf("%4d", u1.getUpdown()[k]);	// 1.up 2.down 3.match
			System.out.println();
		}
	}
	
}