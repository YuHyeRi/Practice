package javaDay1;

import java.util.Scanner;

public class Java_trapezoid {
	// �������� 5
	public static void main(String[] args) {
		
	int up, down, length;
	
	Scanner sc = new Scanner(System.in);
	System.out.println("������?");
	up = sc.nextInt();
	System.out.println("�Ʒ�����?");
	down = sc.nextInt();
	System.out.println("���̴�?");
	length = sc.nextInt();
	
	System.out.println("��ٸ��� ������ " + ((up + down) * length) / 2 + " �Դϴ�.");
		
	}
}
