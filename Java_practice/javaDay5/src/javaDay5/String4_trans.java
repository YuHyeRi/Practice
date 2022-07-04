package javaDay5;

import java.util.Scanner;

public class String4_trans {

	public static void main(String[] args) {
		
		/*
		System.out.println((int)'0');		//48(문자0)
		System.out.println((int)'1');		//49
		System.out.println((int)'2');		//50
		
		System.out.println(('0' - '0'));		//0
		System.out.println(('0' -  48));		//0 (위랑 같다)
		System.out.println(('1' - '0'));		//1
		System.out.println(('1' - 48));			//1
		System.out.println(('2' - '0'));		//2
		System.out.println(('2' - 48));			//2
		*/
		
		Scanner sc = new Scanner(System.in);

		// 1. 문자를 받아 숫자로 출력하기
		char ch;
		System.out.print("알파벳 입력 : ");
		ch = sc.next().charAt(0);
		
		int num = ch;
		System.out.println(num);
		
		// 2. 숫자를 받아 문자로 출력하기
		int num2;
		System.out.print("숫자 입력 : ");
		num2 = sc.nextInt();
		
		char ch2 = (char) num2;
		System.out.println(ch2);
		
		
		
	}
}
