package javaDay2;

import java.util.Scanner;

public class If_grade2 {
	// �������� 13
	public static void main(String[] args) {
		
		int a, b, c, d;
		
		// a, b, c : 200�� ���� + d : 400������		
		Scanner sc = new Scanner(System.in);
		System.out.println("�������� : ");
		a = sc.nextInt();
		System.out.println("���������̼� ���� : ");
		b = sc.nextInt();
		System.out.println("���������Ʈ ���� : ");
		c = sc.nextInt();
		System.out.println("�ʱ����� : ");
		d = sc.nextInt();
		
		int total = a + b + c + d;
		if (total >= 800) {
			System.out.println("1���");
		} else if(total >= 600) {
			System.out.println("2���");
		} else if(total >= 400) {
			System.out.println("3���");
		} else {
			System.out.println("4���");
			System.out.println("�������!!");
		}
		
	}
}
