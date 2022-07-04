package javaDay6;

import java.util.Scanner;

public class Array5_jinsuTrans {
	// 10진수를 받아 2진수로 변환하여 출력
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		String str ="";	// 문자 출력할 변수
		
		System.out.println("2진수로 변환할 정수를 입력하세요.");
		int num = sc.nextInt();
		
		int i;
		for(i=num; i>0; i/=2) {		// 한바퀴 돌때마다 나누기2
			str = String.valueOf(i%2 + str);	// + str
		} System.out.println(str);
		
	}
}
