package javaDay1;

import java.util.Scanner;

public class Java_temperature {
	// �������� 7, 8
	public static void main(String[] args) {
		
		double hwa, sup;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("ȭ�� �µ��� �Է��ϼ���.");
		hwa = sc.nextDouble();
		sup = (double) (hwa-32) * 0.55;
		System.out.println("������ " +  sup + "�Դϴ�.");	
		
		System.out.println();
		
		System.out.println("���� �µ��� �Է��ϼ���.");
		sup = sc.nextDouble();
		hwa = (double) (sup*1.8) + 32;
		System.out.println("ȭ���� " + hwa + "�Դϴ�.");
	}
}
