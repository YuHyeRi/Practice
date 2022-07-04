package javaDay4;

import java.util.Scanner;

public class Repeat_Exam1 {
	// 년도 윤년 세기
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int start, end;
		int i;
		int cnt = 0;	// 카운트용
		
		System.out.print("시작년도 : ");
		start = sc.nextInt();
		System.out.print("종료년도 : ");
		end = sc.nextInt();
		
		// for문 버전
		for(i=start; i<=end; i++) {
			if((i % 4 == 0 && i % 100 != 0) || i % 400 == 0)
				cnt++;
		} System.out.println("for문 결과 : " + cnt);
		
		// while문 버전
		int cnt2 = 0;
		int i2 = 2000;
		while(i2 <= 3000) {
			if((i2 % 4 == 0 && i2 % 100 != 0) || i2 % 400 == 0)
				cnt2++;
				i2++;
		} System.out.println("while문 결과 : " + cnt);
		
	}
}
