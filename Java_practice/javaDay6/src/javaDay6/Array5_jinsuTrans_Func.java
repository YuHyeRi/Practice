package javaDay6;

import java.util.Scanner;

public class Array5_jinsuTrans_Func {
	// �Լ��� �̿��ؼ� ������ 10������ 2����, 8����, 16������ ����ϱ�
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);

		System.out.print("���� �Է� : ");
		int num = sc.nextInt();
		
		String a2 = Integer.toBinaryString(num);	// 2����
		String a8 = Integer.toOctalString(num);		// 8����
		String a16 = Integer.toHexString(num);		// 16����
		
		System.out.println("2���� : " + a2);
		System.out.println("8���� : " + a8);
		System.out.println("16���� : " + a16);
		
	}
}
