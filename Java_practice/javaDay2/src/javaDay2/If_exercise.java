package javaDay2;

import java.util.Scanner;

public class If_exercise {
	// ��������  11
	public static void main(String[] args) {
		
		int temp;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("���� �µ���?");
		temp = sc.nextInt();
		
		if(temp > 30) {
			System.out.println("����");
		} else if(temp > 24) {
			System.out.println("�״Ͻ�");
		} else if(temp > 20) {
			System.out.println("����");
		} else if(temp > 0) {
			System.out.println("��Ű");
		} else {
			System.out.println("��");
		}
	}
}
