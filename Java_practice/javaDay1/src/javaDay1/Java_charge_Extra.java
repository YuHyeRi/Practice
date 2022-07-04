package javaDay1;

import java.util.Scanner;

public class Java_charge_Extra {
	
	public static void main(String[] args) {
		
		int totalMoney;
		int m1, m2, m3, m4, m5, m6, m7, m8;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("거스름돈은?");
		totalMoney = sc.nextInt();
		
		m1 = totalMoney/50000;
		m2 = totalMoney%50000/10000;
		m3 = totalMoney%50000%10000/5000;
		m4 = totalMoney%50000%10000%5000/1000;
		m5 = totalMoney%50000%10000%5000%1000/500;
		m6 = totalMoney%50000%10000%5000%1000%500/100;
		m7 = totalMoney%50000%10000%5000%1000%500%100/50;
		m8 = totalMoney%50000%10000%5000%1000%500%100%50/10;
		
		System.out.println("잔액은 : " + totalMoney);
		System.out.println("5만원 : " + m1 + "장");
		System.out.println("1만원 : " + m2 + "장");
		System.out.println("5천원 : " + m3 + "장");
		System.out.println("1천원 : " + m4 + "장");
		System.out.println("5백원 : " + m5 + "개");
		System.out.println("1백원 : " + m6 + "개");
		System.out.println("50원 : " + m7 + "개");
		System.out.println("10원 : " + m8 + "개");

	}
}
