package javaDay5;

import java.util.Scanner;

public class String1_01trans {
	// �������� �Է�������, 0�� 1�� �ٲ�����ϰ� 1�� 0���� �ٲ� ���
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String num1;
		String num2 = "";
		int i;
		
		System.out.println("�����Է� : ");
		num1 = sc.next();
		
		for(i=0; i<num1.length(); i++) {
			if(num1.charAt(i) == '0') {
				num2+="1";	// num2 = num2 + 1 --> 1�� ���
			} else {
				num2+="0";	// num2 = num2 + 0 --> 0�� ���
			}
		}
		System.out.println(num2);
		
	}
}
