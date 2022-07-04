package javaDay3;

import java.util.Scanner;

public class Switch_Exam2_Extra {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int inputNum;
		int radius, width, heigth;
		double result = 0;
		
		System.out.println("1. 원의둘레");
		System.out.println("2. 삼각형둘레");
		System.out.println("3. 사각형둘레");
		
		System.out.println();
		System.out.println("번호를 입력하세요.");
		inputNum = sc.nextInt();
		
		switch(inputNum) {
		case 1 : 
			System.out.println("반지름 : ");
			radius = sc.nextInt();
			result = radius * radius * 3.14 ;
			break;
		case 2 : 
			System.out.println("밑변길이 : ");
			width = sc.nextInt();
			System.out.println("높이 : ");
			heigth = sc.nextInt();
			result = (width * heigth) / 2;
			break;
			
		case 3 : 
			System.out.println("가로길이 : ");
			width = sc.nextInt();
			System.out.println("세로길이 : ");
			heigth = sc.nextInt();
			result = width * heigth;
			break;
		}
		System.out.printf("\n면적은 %.1f 입니다.\n", result);
		
		
	}
}
