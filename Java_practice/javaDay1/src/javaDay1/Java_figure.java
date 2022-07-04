package javaDay1;

import java.util.Scanner;

public class Java_figure {
	// 연습문제 9
	public static void main(String[] args) {
		
		int w, h, l;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("가로길이는?");
		w = sc.nextInt();
		System.out.println("세로길이는?");
		h = sc.nextInt();
		
		l = (int)Math.sqrt(w*w + h*h);
		System.out.println("빗변의 길이는 " + l + "입니다.");
		
		
		
	}
}
