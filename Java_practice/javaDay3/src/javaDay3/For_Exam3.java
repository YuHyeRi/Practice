package javaDay3;

import java.util.Scanner;

public class For_Exam3 {
	// �⺻���� �Ŵϱ� �̰� �ܿ��!!!
	public static void main(String[] args) {
		
		// 1���� 10������ �հ� ���ϱ�
		int i;
		int sum = 0;
		for(i = 1; i <= 10; i++) {
			sum += i;		// sum = sum + i;
			// System.out.printf("i=%d s=%d\n", i, sum);
		}
		System.out.println("1. 1���� 10������ �հ� : " + sum);
		
		System.out.println();
		
		// 1~100 ���� �߿���, ¦���� �հ� Ȧ���� ���� ���� ���϶�
		int j;
		int even = 0;
		int odd = 0;
		
		for(j = 1; j <= 100; j++) {
			if(j % 2 == 0) {
				even += j;
			} else {
				odd += j;
			}
		}
		System.out.println("2-1. ¦���� �� : " + even);
		System.out.println("2-2. Ȧ���� �� : " + odd);
		
		System.out.println();
		
		// 10�� �Է¹޾�, ¦���� ¦������ ���, Ȧ���� Ȧ������ ��� ���ϱ�
		
		Scanner sc = new Scanner(System.in);
		
		int z, num;
		int evenResult = 0;
		int oddResult = 0;
		
		for(z = 1; z <= 10; z++) {
	         System.out.print("���ڸ� �Է��ϼ��� : ");
	         num = sc.nextInt();
	    
	         if(num % 2 == 0) {
	            evenResult += num;
	         }else {
	            oddResult += num;
	         }
	      }
		System.out.println("¦���� : " + evenResult);
		System.out.println("Ȧ���� : " + oddResult);
		
		
	}
}
