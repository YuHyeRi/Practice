package javaDay2;

import java.util.Scanner;

public class If_earthquake {
		// �������� 6
	public static void main(String[] args) {
		
		double richter;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�����͸� �Է��ϼ���.");
		richter = sc.nextDouble();
		
		if(richter <= 5.0) {
			System.out.println("����ϰų� ���� ���� ����");
		} else if(richter <= 5.5) {
			System.out.println("�ణ�� ����");
		} else if(richter <= 6.5) {
			System.out.println("�ߴ��� ����, ���� �μ����ų� ������");
		} else if(richter <= 7.5) {
			System.out.println("����, �� �Ǵ� �ǹ��� �ر��� �� ����");
		} else {
			System.out.println("���, ��κ��� �ǹ��� �ر���");
		}

	}
}
