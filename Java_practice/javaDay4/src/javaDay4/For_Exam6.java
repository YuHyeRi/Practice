package javaDay4;

import java.util.Scanner;

public class For_Exam6 {
	// �������� 24
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str;
		int i;
		
		System.out.println("������ �Է��ϼ���!");
		str = sc.nextLine();
		
		
		for(i = 0; i < str.length(); i++) {
			if(str.charAt(i) == ' ' || str.charAt(i) == '.' || str.charAt(i) == ',')
				System.out.println();
			else 
			System.out.print(str.charAt(i));	// ������ �ѱ��ھ� ��µ�
			}
		
	}
}
