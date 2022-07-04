package javaDay2;

import java.util.Scanner;

public class If_flatMoon {
		// 연습문제 10
	public static void main(String[] args) {
		
		int year, month, day;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("연도를 입력하세요.");
		year = sc.nextInt();
		
		if((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
			System.out.println("윤년 입니다.");
		} else {
			System.out.println("평년 입니다.");
		};
			
	}
}
