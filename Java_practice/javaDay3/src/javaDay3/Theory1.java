package javaDay3;

import java.util.Scanner;

public class Theory1 {
	// �ڹ� 7�������ʹ� switch���� ����(��)�� �� �� ����
	// ��Ʈ��+����Ʈ+X : �빮�ڷ�
	// ��Ʈ��+����Ʈ+Y : �ҹ��ڷ�
	// ��Ʈ��+����Ʈ+O : import�� �ѹ���
	// ��Ʈ��+H : ��ü ������Ʈ ������ ������ ã����
	public static void main(String[] args) {
	
		// 1. ������ ��� (����ġ���� �Ǽ��� �ȵ�!, �׷��� ��� *10 ���� �Ἥ �ϸ� ��)
		int a;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�����Է�");
		a = sc.nextInt();
		
		switch(a) {
		case 1 : 
			System.out.println("1������");
			break;
		case 2 : 
			System.out.println("2������");
			break;
		case 3 : 
			System.out.println("3������");
			break;
		default :
			System.out.println("no choice");
		}
		
		// 2. ������ ���
		char b;
		Scanner sc2 = new Scanner(System.in);
		
		System.out.println("�����Է�");
		b = sc2.next().charAt(0);
		
		switch(b) {
		case 'A' : 
		case 'a' : 
			System.out.println("A ����");
			break;
		case 'B' : 
		case 'b' :
			System.out.println("B ����");
			break;
		case 'C' : 
		case 'c' : 
			System.out.println("B ����");
			break;
		default : 
			System.out.println("no choice");
		}
		
		// 3. ���ڿ��� ���
		String foo;
		Scanner sc3 = new Scanner(System.in);
		
		System.out.println("�����ϴ� ������?");
		foo = sc3.nextLine();
		
		switch(foo) {
		case "����" : 
			System.out.println("���⼱��");
			break;
		case "����" : 
			System.out.println("��������");
			break;
		case "����" : 
			System.out.println("���ڼ���");
			break;
		default : 
			System.out.println("no choice");
		}
	}
}
