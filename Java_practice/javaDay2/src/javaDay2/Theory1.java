package javaDay2;

import java.util.Scanner;

public class Theory1 {

	public static void main(String[] args) {
		/*
		int a = 5;
		int b = 6;
		
		System.out.printf("%d >  %d = %b%n", a, b, a>b );
		System.out.printf("%d <  %d = %b%n", a, b, a<b );
		System.out.printf("%d >= %d = %b%n", a, b, a>=b);
		System.out.printf("%d <= %d = %b%n", a, b, a<=b);
		System.out.printf("%d == %d = %b%n", a, b, a==b);
		System.out.printf("%d != %d = %b%n", a, b, a!=b);
		*/
		
		/*
		값 타입 변수 : 값을 저장 (int, float, char,...)
		참조타입 : 값의 주소를 저장 (class, 배열) (cf. 자바스크립트는 all 참조타입)
		*/
		
		String s1 = "hello";	// hello : 문자열 리터럴
		String s2 = "hello";	// s1과 s2는 동일한 데이터 공간을 가르킴
		
		System.out.println(s1 == s2);
		// 단, int는 값을 물어보는게 맞고
		// String은 내용을 물어보는게 아닌, 메모리를 공유하는지를 물어봄 (값 비교는 .equals를 씀)
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("단어 : ");
		s1 = sc.next();
		
		System.out.println("단어 : ");
		s2 = sc.next();
		
		System.out.printf("%s %s%n", s1, s2);
		System.out.println(s1 == s2);	// false : 공간 비교
		System.out.println(s1.equals(s2));	// true : 값 비교

	}
}
