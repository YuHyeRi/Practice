package javaDay1;

import java.util.Scanner;

public class Java_salary {
	// �������� 3
	public static void main(String[] args) {
		
		int hour, money;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�ٹ��ð���?");
		hour = sc.nextInt();
		System.out.println("�ñ���?");
		money = sc.nextInt();
		
		System.out.println((hour * money) + "��");
	}
}
