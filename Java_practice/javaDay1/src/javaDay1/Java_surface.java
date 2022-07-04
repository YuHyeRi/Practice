package javaDay1;

import java.util.Scanner;

public class Java_surface {
	/*
	 * 1. 문제에 대한 정의(입력데이터, 출력데이터)
	 * 2. 충분한 변수 선언
	 * 3. 데이터 입력
	 * 4. 계산
	 * 5. 출력
	 */
	public static void main(String[] args) {
		
		int width, heigth;
		int surface;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("가로 : ");
		width = sc.nextInt();
		System.out.println("세로 : ");
		heigth = sc.nextInt();
		
		surface = width * heigth;
		System.out.println("면적은 " + surface + " 입니다.");
		
		
	}
}
