package javaDay1;

import java.util.Scanner;

public class Java_salary {
	// 연습문제 3
	public static void main(String[] args) {
		
		int hour, money;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("근무시간은?");
		hour = sc.nextInt();
		System.out.println("시급은?");
		money = sc.nextInt();
		
		System.out.println((hour * money) + "원");
	}
}
