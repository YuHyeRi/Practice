package javaDay3;

import java.util.Scanner;

public class For_Exam3_Extra {
	// 10�� �Է¹޾�, ¦���� ¦������ ���, Ȧ���� Ȧ������ ��� ���ϱ�
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int evenSum = 0;	// ¦����
		int evenCnt = 0;	// ¦�����
		int oddSum = 0;		// Ȧ����
		int oddCnt = 0;		// Ȧ�����
		int num; // ������ ������ ����
		int i;	// ������ ������ ����
		
		for(i = 1; i <= 10; i++) {
			System.out.println("�����Է�" + i + ": ");
			num = sc.nextInt();
			if(num % 2 == 0) {
				evenSum += num;
				evenCnt++;
			} else {
				oddSum += num;
				oddCnt++;
			}
		}
		if(evenCnt > 0) {
			System.out.printf("¦���� %d\n", evenSum + evenCnt);
			System.out.printf("¦����� %d\n", evenSum / evenCnt);
		}
		if(oddCnt > 0) {
			System.out.printf("Ȧ���� %d\n", oddSum + oddCnt);
			System.out.printf("Ȧ����� %d\n", oddSum / oddCnt);
		}
		}
}
