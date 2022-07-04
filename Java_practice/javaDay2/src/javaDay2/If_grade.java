package javaDay2;

import java.util.Scanner;

public class If_grade {
	// 연습문제 12
	public static void main(String[] args) {
	
		int a, b, c, d;
		 
		Scanner sc = new Scanner(System.in);
		
		System.out.println("A점수 : ");
		a = sc.nextInt();
		System.out.println("B점수 : ");
		b = sc.nextInt();
		System.out.println("C점수 : ");
		c = sc.nextInt();
		System.out.println("D점수 : ");
		d = sc.nextInt();
		
		int average = (a + b + c + d)/4;
		boolean under = a>=40 && b>=40 && c>=40 && d>=40;

		if(under && average>=60) {
			System.out.println("합격입니다.");
		} else {
			System.out.println("불합격입니다.");
		}
		
	}
}
