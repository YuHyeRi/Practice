package javaDay6;

import java.util.Scanner;

public class Exam2 {
	// 100������ �������� �Է°� �޾� �� ��� ���ϱ�(�ٸ��������� ����)
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int i;
		int cnt = 0;
		double sum = 0;
		
		System.out.print("�����Է� :  ");
		
		while((i=sc.nextInt())>0 && i<=100) {
			System.out.print("�����Է� : ");
			sum+=i;
			cnt++;
		} System.out.printf("��� : %.2f", sum/cnt);
		
		
	}
}
