package javaDay1;

import java.util.Scanner;

public class Java_km {
	// �������� 1
	public static void main(String[] args) {
		
		int meter;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("���͸� �Է��ϼ���.");
		meter = sc.nextInt();
		
		System.out.println((meter/1000) + "km " + (meter%1000) + "m");
		
	}
}
