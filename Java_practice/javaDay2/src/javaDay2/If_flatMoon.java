package javaDay2;

import java.util.Scanner;

public class If_flatMoon {
		// �������� 10
	public static void main(String[] args) {
		
		int year, month, day;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("������ �Է��ϼ���.");
		year = sc.nextInt();
		
		if((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
			System.out.println("���� �Դϴ�.");
		} else {
			System.out.println("��� �Դϴ�.");
		};
			
	}
}
