package javaDay4;

import java.util.Scanner;

public class DoWhile_Exam2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num;
		int w, h;
		char again;
		double circle, result;
		final double PI = 3.14;
		
		do {
			System.out.println("1. ���� ����");
			System.out.println("2. �簢���� ����");
			System.out.print("���� ��ȣ �Է� : ");
			num = sc.nextInt();
			
			switch(num) {
			case 1 : 
				System.out.print("������ : ");
				circle = sc.nextDouble();
				result = circle*circle*PI;
				System.out.printf("��� : %.2f\n", result);
				break;
				
			case 2 : 
				System.out.print("���α��� : ");
				w = sc.nextInt();
				System.out.print("���α��� : ");
				h = sc.nextInt();
				result = w * h;
				System.out.printf("��� : %.2f\n", result);
				break;
				
			default : 
					System.out.println("���ڸ� �ٽ� �Է��ϼ���.");	
			}
			System.out.print("����Ͻðڽ��ϱ�?");
			again = sc.next().charAt(0);
		} while (again == 'Y' || again == 'y');
		
		
		
	}	// main
}	// class
