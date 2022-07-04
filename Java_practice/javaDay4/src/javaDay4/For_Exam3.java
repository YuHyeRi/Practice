package javaDay4;

import java.util.Scanner;
	// 구구단 만들기
public class For_Exam3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		// 가로버전
		int start, end;
		int i, j;
		
		System.out.print("몇단부터? ");
		start = sc.nextInt();
		System.out.print("몇단까지? ");
		end = sc.nextInt();
		
		for(i=1; i<=9; i++) {
			for(j=start; j<=end; j++) {
				System.out.printf("%d x %d = %d\t", j, i, i*j);
			}
			System.out.println();
		}
		
		// 세로버전
		for(i=start; i<=end; i++) {
			for(j=1; j<=9; j++) {
				System.out.printf("%d x %d = %d\n", i, j, i*j);
			}
			System.out.println();
		}
		
	      
	}
}
