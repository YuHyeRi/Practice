package javaDay3;

import java.util.Scanner;

public class Switch_Exam2_Extra {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int inputNum;
		int radius, width, heigth;
		double result = 0;
		
		System.out.println("1. ���ǵѷ�");
		System.out.println("2. �ﰢ���ѷ�");
		System.out.println("3. �簢���ѷ�");
		
		System.out.println();
		System.out.println("��ȣ�� �Է��ϼ���.");
		inputNum = sc.nextInt();
		
		switch(inputNum) {
		case 1 : 
			System.out.println("������ : ");
			radius = sc.nextInt();
			result = radius * radius * 3.14 ;
			break;
		case 2 : 
			System.out.println("�غ����� : ");
			width = sc.nextInt();
			System.out.println("���� : ");
			heigth = sc.nextInt();
			result = (width * heigth) / 2;
			break;
			
		case 3 : 
			System.out.println("���α��� : ");
			width = sc.nextInt();
			System.out.println("���α��� : ");
			heigth = sc.nextInt();
			result = width * heigth;
			break;
		}
		System.out.printf("\n������ %.1f �Դϴ�.\n", result);
		
		
	}
}
