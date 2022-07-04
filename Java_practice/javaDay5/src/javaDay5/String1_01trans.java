package javaDay5;

import java.util.Scanner;

public class String1_01trans {
	// 정수값을 입력했을때, 0은 1로 바꿔출력하고 1은 0으로 바꿔 출력
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String num1;
		String num2 = "";
		int i;
		
		System.out.println("정수입력 : ");
		num1 = sc.next();
		
		for(i=0; i<num1.length(); i++) {
			if(num1.charAt(i) == '0') {
				num2+="1";	// num2 = num2 + 1 --> 1이 출력
			} else {
				num2+="0";	// num2 = num2 + 0 --> 0이 출력
			}
		}
		System.out.println(num2);
		
	}
}
