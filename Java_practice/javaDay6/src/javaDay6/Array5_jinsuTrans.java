package javaDay6;

import java.util.Scanner;

public class Array5_jinsuTrans {
	// 10������ �޾� 2������ ��ȯ�Ͽ� ���
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		String str ="";	// ���� ����� ����
		
		System.out.println("2������ ��ȯ�� ������ �Է��ϼ���.");
		int num = sc.nextInt();
		
		int i;
		for(i=num; i>0; i/=2) {		// �ѹ��� �������� ������2
			str = String.valueOf(i%2 + str);	// + str
		} System.out.println(str);
		
	}
}
