package javaDay1;

import java.util.Scanner;

public class Java_temperature {
	// 연습문제 7, 8
	public static void main(String[] args) {
		
		double hwa, sup;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("화씨 온도를 입력하세요.");
		hwa = sc.nextDouble();
		sup = (double) (hwa-32) * 0.55;
		System.out.println("섭씨는 " +  sup + "입니다.");	
		
		System.out.println();
		
		System.out.println("섭씨 온도를 입력하세요.");
		sup = sc.nextDouble();
		hwa = (double) (sup*1.8) + 32;
		System.out.println("화씨는 " + hwa + "입니다.");
	}
}
