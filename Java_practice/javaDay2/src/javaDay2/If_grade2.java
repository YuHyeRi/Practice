package javaDay2;

import java.util.Scanner;

public class If_grade2 {
	// 연습문제 13
	public static void main(String[] args) {
		
		int a, b, c, d;
		
		// a, b, c : 200점 만점 + d : 400점만점		
		Scanner sc = new Scanner(System.in);
		System.out.println("워드점수 : ");
		a = sc.nextInt();
		System.out.println("프레젠테이션 점수 : ");
		b = sc.nextInt();
		System.out.println("스프레드시트 점수 : ");
		c = sc.nextInt();
		System.out.println("필기점수 : ");
		d = sc.nextInt();
		
		int total = a + b + c + d;
		if (total >= 800) {
			System.out.println("1등급");
		} else if(total >= 600) {
			System.out.println("2등급");
		} else if(total >= 400) {
			System.out.println("3등급");
		} else {
			System.out.println("4등급");
			System.out.println("재시험요망!!");
		}
		
	}
}
