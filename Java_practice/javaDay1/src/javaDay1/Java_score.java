package javaDay1;

import java.util.Scanner;

public class Java_score {
	// �������� 6	
	public static void main(String[] args) {
		
		String name;
		int kor, eng, math;
		int total;
		int average;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�̸��� �Է��ϼ���.");
		name = sc.nextLine();
		
		System.out.println("����������?");
		kor = sc.nextInt();
		
		System.out.println("����������?");
		eng = sc.nextInt();
		
		System.out.println("����������?");
		math = sc.nextInt();
		
		total = kor + eng + math;
		average = (kor + eng + math) / 3;
		
		System.out.println(name + "�� ������ " + total + "�̸�, ����� " + average + "�Դϴ�.");
	}
}
