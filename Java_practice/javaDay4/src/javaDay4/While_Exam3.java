package javaDay4;

import java.util.Scanner;
	// ���� �Է¹޾�, �� ��� �������� �հ� ����� ���϶�. ��, ���� ������ �Է��ϸ� ����
public class While_Exam3 {
		
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num;
		int cnt = 0;	// ��� ���Ҷ� ������
		int sum = 0;
		
		System.out.print("���� : ");
		num = sc.nextInt();
		
		while(num>=0) {
			sum+=num;
			cnt++;
			
			System.out.print("���� : ");
			num = sc.nextInt();
		}
		System.out.printf("�հ� : %d\n��� : %d", sum, sum/cnt);		
	}
}
