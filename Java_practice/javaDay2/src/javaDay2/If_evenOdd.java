package javaDay2;

import java.util.Scanner;

public class If_evenOdd {
	
	public static void main(String[] args) {
		
		int a;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("���ڸ� �Է��ϼ���.");
		a = sc.nextInt();
		
		if(a%2 == 0) {
			System.out.println("¦���̴�.");
		} else if(a%2 != 0) {
			System.out.println("Ȧ���̴�.");
		}
		
	}
}
