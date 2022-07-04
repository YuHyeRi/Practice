package javaDay3;

import java.util.Scanner;

public class Switch_Exam2 {
	// 원의 면적 : 반지름 제곱 * 3.14
	// 삼각형 면적 : 밑변 * 높이
	// 사각형 면적 : 가로 * 세로
	public static void main(String[] args) {
		
		int num = 0;
		int t1, t2, s1, s2;
		double cResult, tResult, sResult;
		double circle;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("케이스를 선택하세요.");
		num = sc.nextInt();
		
		switch(num) {
		case 1 : 
			System.out.println("지름 : ");
			circle = sc.nextDouble();
			cResult = circle * 3.14;
			System.out.println("원의 면적은 " + cResult + " 입니다.");
			break;
		
		case 2 : 
			System.out.println("밑변 : ");
			t1 = sc.nextInt();
			System.out.println("높이 : ");
			t2 = sc.nextInt();
			tResult = t1*t2;
			System.out.println("삼각형의 면적은 " + tResult + " 입니다.");
			break;
		
		case 3 : 
			System.out.println("가로 : ");
			s1 = sc.nextInt();
			System.out.println("세로 : ");
			s2 = sc.nextInt();
			sResult = s1*s2;
			System.out.println("사각형의 면적은 " + sResult + " 입니다.");
			break;
		default : 
			System.out.println("1~3까지의 숫자를 입력하세요.");
		}
		

	}
}
