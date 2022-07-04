package javaDay4;

import java.util.Scanner;

public class DoWhile_Exam2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num;
		int w, h;
		char again;
		double circle, result;
		final double PI = 3.14;
		
		do {
			System.out.println("1. 원의 면적");
			System.out.println("2. 사각형의 면적");
			System.out.print("선택 번호 입력 : ");
			num = sc.nextInt();
			
			switch(num) {
			case 1 : 
				System.out.print("반지름 : ");
				circle = sc.nextDouble();
				result = circle*circle*PI;
				System.out.printf("결과 : %.2f\n", result);
				break;
				
			case 2 : 
				System.out.print("가로길이 : ");
				w = sc.nextInt();
				System.out.print("세로길이 : ");
				h = sc.nextInt();
				result = w * h;
				System.out.printf("결과 : %.2f\n", result);
				break;
				
			default : 
					System.out.println("숫자를 다시 입력하세요.");	
			}
			System.out.print("계속하시겠습니까?");
			again = sc.next().charAt(0);
		} while (again == 'Y' || again == 'y');
		
		
		
	}	// main
}	// class
