package javaDay1;

import java.util.Scanner;

public class Java_surface {
	/*
	 * 1. ������ ���� ����(�Էµ�����, ��µ�����)
	 * 2. ����� ���� ����
	 * 3. ������ �Է�
	 * 4. ���
	 * 5. ���
	 */
	public static void main(String[] args) {
		
		int width, heigth;
		int surface;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("���� : ");
		width = sc.nextInt();
		System.out.println("���� : ");
		heigth = sc.nextInt();
		
		surface = width * heigth;
		System.out.println("������ " + surface + " �Դϴ�.");
		
		
	}
}
