package javaDay2;

import java.util.Scanner;

public class If_payCheck {

	public static void main(String[] args) {
		
		int hour, money;
		String name;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�̸��� �Է��ϼ���.");
		name = sc.nextLine();
		System.out.println("�ٹ��ð��� �Է��ϼ���.");
		hour = sc.nextInt();
		System.out.println("�ñ��� �Է��ϼ���.");
		money = sc.nextInt();
		
		int notOver = hour * money;
		int over = notOver + ((hour-20) * (money/2));
		
		if(hour < 20) {
			System.out.println(name + "���� �ѱ޿��� " + notOver + " �� �Դϴ�.");
		} else if(hour > 20) {
			System.out.println(name + "���� �ѱ޿��� " + over + " �� �Դϴ�.");
		}
		
	}
}
