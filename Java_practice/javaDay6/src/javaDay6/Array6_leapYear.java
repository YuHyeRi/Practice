package javaDay6;

import java.util.Scanner;

public class Array6_leapYear {
	// �迭�̿��Ͽ� ����, ��ü�ϼ� ����ϱ�
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] days = new int[] {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		System.out.print("�⵵�Է� : ");
		int year = sc.nextInt();
		System.out.print("�� �Է� : ");
		int month = sc.nextInt();
		System.out.print("�� �Է� : ");
		int day = sc.nextInt();
		
		if(year%4 == 0 && year%100 != 0 || year%400 == 0) {
			days[2] = 29;	// ������ ���, 2������ 29�Ϸ� ����
		}
		
		int totalDays = 0;
		for(int i = 1; i<month; i++) {	// ex. 7�� 5���� ���ϴ°Ŷ��, 6�� ������ ���ؾ��ϴϱ� (=<�� �ƴ� <)
			totalDays+=days[i];	// 7��5���̸� 6�������� ���� ��
		} 
		totalDays+=day;	// 7��5���̸� ������ 5���� ���� ��
		System.out.println(" ==>" + year + "���� ���۵��� " + totalDays + "��°");
		
	}
}
