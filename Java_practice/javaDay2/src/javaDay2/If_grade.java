package javaDay2;

import java.util.Scanner;

public class If_grade {
	// �������� 12
	public static void main(String[] args) {
	
		int a, b, c, d;
		 
		Scanner sc = new Scanner(System.in);
		
		System.out.println("A���� : ");
		a = sc.nextInt();
		System.out.println("B���� : ");
		b = sc.nextInt();
		System.out.println("C���� : ");
		c = sc.nextInt();
		System.out.println("D���� : ");
		d = sc.nextInt();
		
		int average = (a + b + c + d)/4;
		boolean under = a>=40 && b>=40 && c>=40 && d>=40;

		if(under && average>=60) {
			System.out.println("�հ��Դϴ�.");
		} else {
			System.out.println("���հ��Դϴ�.");
		}
		
	}
}
