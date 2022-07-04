package javaDay4;

import java.util.Scanner;

public class For_Exam6 {
	// 연습문제 24
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str;
		int i;
		
		System.out.println("문장을 입력하세요!");
		str = sc.nextLine();
		
		
		for(i = 0; i < str.length(); i++) {
			if(str.charAt(i) == ' ' || str.charAt(i) == '.' || str.charAt(i) == ',')
				System.out.println();
			else 
			System.out.print(str.charAt(i));	// 데이터 한글자씩 출력됨
			}
		
	}
}
