package javaDay6;

import java.util.Scanner;

public class Exam2 {
	// 100이하의 양의정수 입력값 받아 그 평균 구하기(다른값들어오면 종료)
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int i;
		int cnt = 0;
		double sum = 0;
		
		System.out.print("정수입력 :  ");
		
		while((i=sc.nextInt())>0 && i<=100) {
			System.out.print("정수입력 : ");
			sum+=i;
			cnt++;
		} System.out.printf("평균 : %.2f", sum/cnt);
		
		
	}
}
