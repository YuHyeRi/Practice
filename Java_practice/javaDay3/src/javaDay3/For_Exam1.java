package javaDay3;

import java.util.Scanner;

public class For_Exam1 {
	
	public static void main(String[] args) {

		System.out.println("1. ¦�����");
		int i;
		for(i = 2; i <= 10; i+=2) {		// += �̷��� �� ���� ����
			System.out.printf("%3d", i);	// ���� �ϳ� �������� 3ĭ�� Ȯ���ض�
			// printf("%3d" : ���η� ���, ���� �ϳ� �� 3ĭ�� ����(���ڸ����� ��ĭ ��� ���ڸ�����..�̷���)
		}
		System.out.println();
		System.out.println("==============================");

		System.out.println("2. Ȧ�����");
		int j;
		for(j = 1; j <= 20; j+=2) {
			System.out.printf("%3d", j);
		}
		System.out.println();
		System.out.println("==============================");

		System.out.println("3. 3�� ��� 10�� ��������");
//		int z;
//		for(z = 3; z <= 30; z+=3) {
//			System.out.printf("%3d", z);
//		}
		int k = 3;						// �������� �ϳ� �� �ؼ�
		for(i = 1; i <= 10; i++) {			// ��� �׳� 10�� ī��Ʈ�� �ϰ�
			System.out.printf("%3d", k);
			k+=3;						// k = k+3 �ݺ�
		}
		System.out.println();
		System.out.println();
		System.out.println("==============================");
		
		System.out.println("4. �ܾ�, Ƚ�� �Է¹޾Ƽ� ����ϱ�");
		
		Scanner sc = new Scanner(System.in);
		
		String str;
		int num, count;
		
		System.out.println("�ܾ� : ");
		str = sc.nextLine();
		System.out.println("�ݺ�Ƚ�� : ");
		count = sc.nextInt();
		
		for(num = 1; num <= count; num++) {
			System.out.println(str);
		}
		

	}	// main
}	// class