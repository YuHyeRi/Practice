package javaDay6;

import java.util.Scanner;

public class Array5_jinsuTrans_Func {
	// 함수를 이용해서 간단히 10진수를 2진수, 8진수, 16진수로 출력하기
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);

		System.out.print("숫자 입력 : ");
		int num = sc.nextInt();
		
		String a2 = Integer.toBinaryString(num);	// 2진수
		String a8 = Integer.toOctalString(num);		// 8진수
		String a16 = Integer.toHexString(num);		// 16진수
		
		System.out.println("2진수 : " + a2);
		System.out.println("8진수 : " + a8);
		System.out.println("16진수 : " + a16);
		
	}
}
