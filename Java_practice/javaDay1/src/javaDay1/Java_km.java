package javaDay1;

import java.util.Scanner;

public class Java_km {
	// 연습문제 1
	public static void main(String[] args) {
		
		int meter;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("미터를 입력하세요.");
		meter = sc.nextInt();
		
		System.out.println((meter/1000) + "km " + (meter%1000) + "m");
		
	}
}
