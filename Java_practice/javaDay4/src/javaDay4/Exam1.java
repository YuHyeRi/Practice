package javaDay4;

import java.util.Scanner;

public class Exam1 {
	// ����, ���� �Է¹޾� �� ������ ��տ��� ���ϰ�, ������ Z�� ������ ����
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		char gender;
		int income;
		int mSum = 0;
		int mCnt = 0;
		int fSum = 0;
		int fCnt = 0;
		
		do {
			System.out.print("���� : ");
			gender = sc.next().charAt(0);
			
			switch(gender) {
			case 'M' :
			case 'm' :
				System.out.print("���� : ");
				income = sc.nextInt();
				mSum+=income;
				mCnt++;
				break;
			case 'F' : 
			case 'f' :
				System.out.print("���� : ");
				income = sc.nextInt();
				fSum+=income;
				fCnt++;
				break;
			case 'Z' : 
			case 'z' :
				System.out.print("Z�� �ԷµǾ� �����մϴ�.");
				System.out.println();
				break;
			default : 
				System.out.println("�˸��� ���ĺ��� �־��ּ���.");
			}
		} while (gender != 'Z' && gender != 'z');
		
		if(mCnt != 0) {
			System.out.printf("������ ��տ����� %d���� �Դϴ�.\n", mSum/mCnt);
		}
		if(fCnt != 0) {
			System.out.printf("������ ��տ����� %d���� �Դϴ�.\n", fSum/fCnt);
		}
		if(mCnt == 0 && fCnt == 0) {
			System.out.println("���� �Է��ϼ���.\n");
		}
		
		
	}
}
