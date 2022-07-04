package javaDay2;

import java.util.Scanner;

public class If_exercise {
	// 연습문제  11
	public static void main(String[] args) {
		
		int temp;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("현재 온도는?");
		temp = sc.nextInt();
		
		if(temp > 30) {
			System.out.println("수영");
		} else if(temp > 24) {
			System.out.println("테니스");
		} else if(temp > 20) {
			System.out.println("골프");
		} else if(temp > 0) {
			System.out.println("스키");
		} else {
			System.out.println("댄스");
		}
	}
}
