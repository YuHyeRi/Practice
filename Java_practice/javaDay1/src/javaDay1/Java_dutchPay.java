package javaDay1;

import java.util.Scanner;

public class Java_dutchPay {
	// �������� 10
	public static void main(String[] args) {
		
		int a, b, c;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("��ġ� : ");
		a = sc.nextInt();
		System.out.println("����� : ");
		b = sc.nextInt();
		System.out.println("�������� : ");
		c = sc.nextInt();
		
		int aPrice = a * 5000;
		int bPrice = b * 4000;
		int cPrice = c * 6000;
		int totalPrice = aPrice + bPrice + cPrice;
		int personalPrice = totalPrice/5;

		System.out.println("�ֹ����� : " + "��ġ�" + a + " �����" + b + " ��������" + c);
		System.out.println("��ġ���� �ݾ� : " + personalPrice);

	}

}
