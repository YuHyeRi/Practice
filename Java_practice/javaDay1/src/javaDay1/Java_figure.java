package javaDay1;

import java.util.Scanner;

public class Java_figure {
	// �������� 9
	public static void main(String[] args) {
		
		int w, h, l;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("���α��̴�?");
		w = sc.nextInt();
		System.out.println("���α��̴�?");
		h = sc.nextInt();
		
		l = (int)Math.sqrt(w*w + h*h);
		System.out.println("������ ���̴� " + l + "�Դϴ�.");
		
		
		
	}
}
