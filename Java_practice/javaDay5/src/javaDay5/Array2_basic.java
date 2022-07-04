package javaDay5;

import java.util.Scanner;

public class Array2_basic {
	// 배열 구조는 이걸 기억하자!! ('입력-계산-출력')
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[10];
		int i;
		int sum = 0;
		int cnt = 0;
		
		// 1. 입력
		for(i=0; i<arr.length; i++) {
			System.out.printf("%d번째 : ", i+1);
			arr[i] = sc.nextInt();
		}
		
		// 2. 계산
		for(i=0; i<arr.length; i++) {
			sum+=arr[i];
			cnt++;
		}
		
		// 3. 출력
		System.out.print(" - 배열요소 : ");
		for(i=0; i<arr.length; i++) {
			System.out.printf("%4d", arr[i]);}
		System.out.println();
		System.out.printf(" - 합계 : %d\n", sum);
		System.out.printf(" - 평균 : %d\n", sum/cnt);
		
		
		
	}
}
