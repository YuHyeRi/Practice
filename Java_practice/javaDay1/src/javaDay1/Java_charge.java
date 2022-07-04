package javaDay1;

import java.util.Scanner;

public class Java_charge {
	// 연습문제 2
	public static void main(String[] args) {
		
		int totalMoney;
		int money1, money2, money3, money4, money5, money6, money7, money8;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("거스름돈은?");
		totalMoney = sc.nextInt();
		
		int temp = totalMoney;	// 중간 연산과정을 저장할 변수선언
		
		money1 = temp / 50000;
		temp = temp % 50000;
		
		money2 = temp / 10000;
		temp = temp % 10000;
		
		money3 = temp / 5000;
		temp = temp % 5000;
		
		money4 = temp / 1000;
		temp = temp % 1000;
		
		money5 = temp / 500;
		temp = temp % 500;
		
		money6 = temp / 100;
		temp = temp % 100;
		
		money7 = temp / 50;
		temp = temp % 50;
		
		money8 = temp / 10;
		temp = temp % 10;
		
		System.out.println("잔액 : " + totalMoney);
		System.out.println("5만원 : " + money1 + "장");
		System.out.println("1만원 : " + money2 + "장");
		System.out.println("5천원 : " + money3 + "장");
		System.out.println("1천원 : " + money4 + "장");
		System.out.println("5백원 : " + money5 + "개");
		System.out.println("1백원 : " + money6 + "개");
		System.out.println("50원 : " + money7 + "개");
		System.out.println("10원 : " + money8 + "개");
		
	}
}
