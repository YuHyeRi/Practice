

import java.util.Scanner;

public class Func2_choice {
	// 1. circle 함수 선언
	public static void circle() {
		Scanner sc = new Scanner(System.in);
		double a, b;
		System.out.print("반지름 : ");
		a = sc.nextDouble();
		b = a * a * 3.14;
		System.out.printf("원의면적 : %.2f\n", b);}
	
	// 2. triangle 함수 선언
	public static void triangle() {
		Scanner sc = new Scanner(System.in);
		int a, b, result;
		System.out.print("밑변 : ");
		a = sc.nextInt();
		System.out.print("높이 : ");
		b = sc.nextInt();
		result = (a*b)/2;
		System.out.printf("삼각형면적 : %d\n", result);}
	
	// 3. rectangle 함수 선언
	public static void rectangle() {
		Scanner sc = new Scanner(System.in);
		int a, b, result;
		System.out.print("한변의 길이 : ");
		a = sc.nextInt();
		System.out.print("한변의 길이 : ");
		b = sc.nextInt();
		result = a*b;
		System.out.printf("사각형면적 : %d\n", result);}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println();
			System.out.println("1.원  2.삼각형  3.사각형  0.종료");
			int sel = sc.nextInt();
			
			switch(sel) {
			case 0 : System.out.println("종료합니다."); 
					return;		// 여기서 함수 종료
			case 1 : circle(); 
					break;
			case 2 : triangle(); 
					break;
			case 3 : rectangle(); 
					break;
			default : System.out.println("숫자를 다시 입력하세요.");}
			}
		
	}
}

