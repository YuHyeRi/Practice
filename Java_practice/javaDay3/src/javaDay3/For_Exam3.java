package javaDay3;

import java.util.Scanner;

public class For_Exam3 {
	// 기본적인 거니까 이건 외우기!!!
	public static void main(String[] args) {
		
		// 1부터 10까지의 합계 구하기
		int i;
		int sum = 0;
		for(i = 1; i <= 10; i++) {
			sum += i;		// sum = sum + i;
			// System.out.printf("i=%d s=%d\n", i, sum);
		}
		System.out.println("1. 1부터 10까지의 합계 : " + sum);
		
		System.out.println();
		
		// 1~100 까지 중에서, 짝수의 합과 홀수의 합을 각각 구하라
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
		System.out.println("2-1. 짝수의 합 : " + even);
		System.out.println("2-2. 홀수의 합 : " + odd);
		
		System.out.println();
		
		// 10개 입력받아, 짝수는 짝수끼리 평균, 홀수는 홀수끼리 평균 구하기
		
		Scanner sc = new Scanner(System.in);
		
		int z, num;
		int evenResult = 0;
		int oddResult = 0;
		
		for(z = 1; z <= 10; z++) {
	         System.out.print("숫자를 입력하세요 : ");
	         num = sc.nextInt();
	    
	         if(num % 2 == 0) {
	            evenResult += num;
	         }else {
	            oddResult += num;
	         }
	      }
		System.out.println("짝수합 : " + evenResult);
		System.out.println("홀수합 : " + oddResult);
		
		
	}
}
