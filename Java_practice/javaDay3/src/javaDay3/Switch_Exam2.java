package javaDay3;

import java.util.Scanner;

public class Switch_Exam2 {
	// ���� ���� : ������ ���� * 3.14
	// �ﰢ�� ���� : �غ� * ����
	// �簢�� ���� : ���� * ����
	public static void main(String[] args) {
		
		int num = 0;
		int t1, t2, s1, s2;
		double cResult, tResult, sResult;
		double circle;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("���̽��� �����ϼ���.");
		num = sc.nextInt();
		
		switch(num) {
		case 1 : 
			System.out.println("���� : ");
			circle = sc.nextDouble();
			cResult = circle * 3.14;
			System.out.println("���� ������ " + cResult + " �Դϴ�.");
			break;
		
		case 2 : 
			System.out.println("�غ� : ");
			t1 = sc.nextInt();
			System.out.println("���� : ");
			t2 = sc.nextInt();
			tResult = t1*t2;
			System.out.println("�ﰢ���� ������ " + tResult + " �Դϴ�.");
			break;
		
		case 3 : 
			System.out.println("���� : ");
			s1 = sc.nextInt();
			System.out.println("���� : ");
			s2 = sc.nextInt();
			sResult = s1*s2;
			System.out.println("�簢���� ������ " + sResult + " �Դϴ�.");
			break;
		default : 
			System.out.println("1~3������ ���ڸ� �Է��ϼ���.");
		}
		

	}
}
