package javaDay4;

import java.util.Scanner;

public class Exam1_Extra {
	// ����, ��� ���ϱ�
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 1. ������ �Է��ڷ� : ����, ����
		// 2. ������ ����ڷ� : ���
		// 3. �� ���� ������ : ������ �հ�, ������ ī��Ʈ
		
		char gender;
		double yearPay;
		double mSum = 0;	// �ʿ��� �������� �ʱ�ȭ
		double fSum = 0;	// �ʿ��� �������� �ʱ�ȭ
		int mCnt = 0;	// �ʿ��� �������� �ʱ�ȭ
		int fCnt = 0;	// �ʿ��� �������� �ʱ�ȭ
		
		System.out.print("���� : ");
		gender = sc.next().charAt(0);
		
		System.out.print("���� : ");
		yearPay = sc.nextDouble();
		
		// �̷������� �տ� !�� �ٿ��� �� ���� ����		
		while(!(gender == 'Z' || gender == 'z')) {
			if(gender == 'M' || gender == 'm') {
				mSum+=yearPay;
				mCnt++;
			} else {
				fSum+=yearPay;
				fCnt++;
			}
			System.out.print("���� : ");
			gender = sc.next().charAt(0);
			
			System.out.print("���� : ");
			yearPay = sc.nextDouble();
		}
		
		if(mCnt!=0) {
			System.out.printf("������տ��� : %.1f ����\n", mSum/mCnt);
		}
		if(fCnt!=0) {
			System.out.printf("������տ��� : %.1f ����\n", fSum/fCnt);
		}
		
	}
}
