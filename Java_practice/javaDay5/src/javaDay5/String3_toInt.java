package javaDay5;

import java.io.IOException;

public class String3_toInt {
		// ���ڿ� -> ���� ��ȯ�ϱ�
	public static void main(String[] args) throws IOException {
		// System.in.read() : �ܼ�â�� �ԷµǴ� ���� ��� �ƽ�Ű�ڵ� ������ �Է� ����(0~255)
		// ����, char������ �ް� �ʹٸ� ����ȯ�� �ʿ���
		// ���� A�� �Է� ������, �ƽ�Ű�ڵ尪�� 65�� �Է�
		// ���� 0�� �Է¹�����, �ƽ�Ű�ڵ尪�� 48�� �Է�
		
		String a = "2";
		String b = "3";
		int result;
		
		// 1. Integer.parseInt()
		result = Integer.parseInt(a) + Integer.parseInt(b);
		System.out.println("1. �հ�� " + result+ " �Դϴ�.");
		
		// 2. Integer.valueOf()
		result = Integer.valueOf(a) + Integer.valueOf(b);
		System.out.println("2. �հ�� " + result + " �Դϴ�.");
		
		// 3. Integer.toString()
		// ���ڸ� ���ڷ� �ٲ���
		
	}
}
