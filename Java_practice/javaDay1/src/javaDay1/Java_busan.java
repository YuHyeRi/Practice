package javaDay1;

import java.util.Scanner;

public class Java_busan {
	// 연습문제 11
	public static void main(String[] args) {
		
		int inputKilometer;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("달린 시속은?");
		inputKilometer = sc.nextInt();
		
		int hour = 430 / inputKilometer;
		int min = 430 % inputKilometer;
		
		System.out.println(hour + "시간" + min + "분");
		

	}
}
