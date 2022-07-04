package javaDay3;

import java.util.Scanner;

public class Theory1 {
	// 자바 7버전부터는 switch문에 문자(열)도 쓸 수 있음
	// 컨트롤+쉬프트+X : 대문자로
	// 컨트롤+쉬프트+Y : 소문자로
	// 컨트롤+쉬프트+O : import를 한번에
	// 컨트롤+H : 전체 프로젝트 뒤져서 데이터 찾아줌
	public static void main(String[] args) {
	
		// 1. 정수일 경우 (스위치문은 실수는 안됨!, 그래서 대신 *10 등을 써서 하면 됨)
		int a;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자입력");
		a = sc.nextInt();
		
		switch(a) {
		case 1 : 
			System.out.println("1을선택");
			break;
		case 2 : 
			System.out.println("2을선택");
			break;
		case 3 : 
			System.out.println("3을선택");
			break;
		default :
			System.out.println("no choice");
		}
		
		// 2. 문자일 경우
		char b;
		Scanner sc2 = new Scanner(System.in);
		
		System.out.println("문자입력");
		b = sc2.next().charAt(0);
		
		switch(b) {
		case 'A' : 
		case 'a' : 
			System.out.println("A 선택");
			break;
		case 'B' : 
		case 'b' :
			System.out.println("B 선택");
			break;
		case 'C' : 
		case 'c' : 
			System.out.println("B 선택");
			break;
		default : 
			System.out.println("no choice");
		}
		
		// 3. 문자열일 경우
		String foo;
		Scanner sc3 = new Scanner(System.in);
		
		System.out.println("좋아하는 과일은?");
		foo = sc3.nextLine();
		
		switch(foo) {
		case "딸기" : 
			System.out.println("딸기선택");
			break;
		case "포도" : 
			System.out.println("포도선택");
			break;
		case "수박" : 
			System.out.println("수박선택");
			break;
		default : 
			System.out.println("no choice");
		}
	}
}
