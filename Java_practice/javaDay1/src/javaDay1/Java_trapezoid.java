package javaDay1;

import java.util.Scanner;

public class Java_trapezoid {
	// 연습문제 5
	public static void main(String[] args) {
		
	int up, down, length;
	
	Scanner sc = new Scanner(System.in);
	System.out.println("윗변은?");
	up = sc.nextInt();
	System.out.println("아랫변은?");
	down = sc.nextInt();
	System.out.println("높이는?");
	length = sc.nextInt();
	
	System.out.println("사다리꼴 면적은 " + ((up + down) * length) / 2 + " 입니다.");
		
	}
}
