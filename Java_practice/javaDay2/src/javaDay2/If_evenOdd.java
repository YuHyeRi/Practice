package javaDay2;

import java.util.Scanner;

public class If_evenOdd {
	
	public static void main(String[] args) {
		
		int a;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자를 입력하세요.");
		a = sc.nextInt();
		
		if(a%2 == 0) {
			System.out.println("짝수이다.");
		} else if(a%2 != 0) {
			System.out.println("홀수이다.");
		}
		
	}
}
