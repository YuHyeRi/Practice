package javaDay5;

import java.util.Scanner;

public class Array2_basic {
	// �迭 ������ �̰� �������!! ('�Է�-���-���')
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[10];
		int i;
		int sum = 0;
		int cnt = 0;
		
		// 1. �Է�
		for(i=0; i<arr.length; i++) {
			System.out.printf("%d��° : ", i+1);
			arr[i] = sc.nextInt();
		}
		
		// 2. ���
		for(i=0; i<arr.length; i++) {
			sum+=arr[i];
			cnt++;
		}
		
		// 3. ���
		System.out.print(" - �迭��� : ");
		for(i=0; i<arr.length; i++) {
			System.out.printf("%4d", arr[i]);}
		System.out.println();
		System.out.printf(" - �հ� : %d\n", sum);
		System.out.printf(" - ��� : %d\n", sum/cnt);
		
		
		
	}
}
