package javaDay1;

import java.util.Scanner;

public class Java_charge_Extra {
	
	public static void main(String[] args) {
		
		int totalMoney;
		int m1, m2, m3, m4, m5, m6, m7, m8;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�Ž�������?");
		totalMoney = sc.nextInt();
		
		m1 = totalMoney/50000;
		m2 = totalMoney%50000/10000;
		m3 = totalMoney%50000%10000/5000;
		m4 = totalMoney%50000%10000%5000/1000;
		m5 = totalMoney%50000%10000%5000%1000/500;
		m6 = totalMoney%50000%10000%5000%1000%500/100;
		m7 = totalMoney%50000%10000%5000%1000%500%100/50;
		m8 = totalMoney%50000%10000%5000%1000%500%100%50/10;
		
		System.out.println("�ܾ��� : " + totalMoney);
		System.out.println("5���� : " + m1 + "��");
		System.out.println("1���� : " + m2 + "��");
		System.out.println("5õ�� : " + m3 + "��");
		System.out.println("1õ�� : " + m4 + "��");
		System.out.println("5��� : " + m5 + "��");
		System.out.println("1��� : " + m6 + "��");
		System.out.println("50�� : " + m7 + "��");
		System.out.println("10�� : " + m8 + "��");

	}
}
