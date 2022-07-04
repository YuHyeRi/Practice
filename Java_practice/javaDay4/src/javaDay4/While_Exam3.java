package javaDay4;

import java.util.Scanner;
	// 정수 입력받아, 그 모든 정수들의 합과 평균을 구하라. 단, 음의 정수를 입력하면 종료
public class While_Exam3 {
		
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num;
		int cnt = 0;	// 평균 구할때 쓸거임
		int sum = 0;
		
		System.out.print("정수 : ");
		num = sc.nextInt();
		
		while(num>=0) {
			sum+=num;
			cnt++;
			
			System.out.print("정수 : ");
			num = sc.nextInt();
		}
		System.out.printf("합계 : %d\n평균 : %d", sum, sum/cnt);		
	}
}
