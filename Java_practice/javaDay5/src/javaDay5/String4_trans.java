package javaDay5;

import java.util.Scanner;

public class String4_trans {

	public static void main(String[] args) {
		
		/*
		System.out.println((int)'0');		//48(����0)
		System.out.println((int)'1');		//49
		System.out.println((int)'2');		//50
		
		System.out.println(('0' - '0'));		//0
		System.out.println(('0' -  48));		//0 (���� ����)
		System.out.println(('1' - '0'));		//1
		System.out.println(('1' - 48));			//1
		System.out.println(('2' - '0'));		//2
		System.out.println(('2' - 48));			//2
		*/
		
		Scanner sc = new Scanner(System.in);

		// 1. ���ڸ� �޾� ���ڷ� ����ϱ�
		char ch;
		System.out.print("���ĺ� �Է� : ");
		ch = sc.next().charAt(0);
		
		int num = ch;
		System.out.println(num);
		
		// 2. ���ڸ� �޾� ���ڷ� ����ϱ�
		int num2;
		System.out.print("���� �Է� : ");
		num2 = sc.nextInt();
		
		char ch2 = (char) num2;
		System.out.println(ch2);
		
		
		
	}
}
