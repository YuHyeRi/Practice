package javaDay2;

import java.util.Scanner;

public class If_etc2 {
		// 연습문제 4,5
	public static void main(String[] args) {
		
		int a, b, c;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자1 : ");
		a = sc.nextInt();
		System.out.println("숫자2 : ");
		b = sc.nextInt();
		System.out.println("숫자3 : ");
		c = sc.nextInt();
		
		if(a>b && a>c) {
			if(b>c) {
				System.out.println(a + " > " + b + " > " + c);
			} else {
				System.out.println(a + " > " + c + " > " + b);
			}
		}
		if(b>a && b>c) {
			if(a>c) {
				System.out.println(b + " > " + a + " > " + c);
			} else {
				System.out.println(b + " > " + c + " > " + a);
			}
		}
		if(c>a && c>b) {
			if(a>b) {
				System.out.println(c + " > " + a + " > " + b);
			} else {
				System.out.println(c + " > " + b + " > " + a);
			}
		}
		
	}	// main
}	// class
