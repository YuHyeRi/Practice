package javaDay1;

import java.util.Scanner;

public class Java_charge {
	// �������� 2
	public static void main(String[] args) {
		
		int totalMoney;
		int money1, money2, money3, money4, money5, money6, money7, money8;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("�Ž�������?");
		totalMoney = sc.nextInt();
		
		int temp = totalMoney;	// �߰� ��������� ������ ��������
		
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
		
		System.out.println("�ܾ� : " + totalMoney);
		System.out.println("5���� : " + money1 + "��");
		System.out.println("1���� : " + money2 + "��");
		System.out.println("5õ�� : " + money3 + "��");
		System.out.println("1õ�� : " + money4 + "��");
		System.out.println("5��� : " + money5 + "��");
		System.out.println("1��� : " + money6 + "��");
		System.out.println("50�� : " + money7 + "��");
		System.out.println("10�� : " + money8 + "��");
		
	}
}
