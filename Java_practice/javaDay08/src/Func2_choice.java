

import java.util.Scanner;

public class Func2_choice {
	// 1. circle �Լ� ����
	public static void circle() {
		Scanner sc = new Scanner(System.in);
		double a, b;
		System.out.print("������ : ");
		a = sc.nextDouble();
		b = a * a * 3.14;
		System.out.printf("���Ǹ��� : %.2f\n", b);}
	
	// 2. triangle �Լ� ����
	public static void triangle() {
		Scanner sc = new Scanner(System.in);
		int a, b, result;
		System.out.print("�غ� : ");
		a = sc.nextInt();
		System.out.print("���� : ");
		b = sc.nextInt();
		result = (a*b)/2;
		System.out.printf("�ﰢ������ : %d\n", result);}
	
	// 3. rectangle �Լ� ����
	public static void rectangle() {
		Scanner sc = new Scanner(System.in);
		int a, b, result;
		System.out.print("�Ѻ��� ���� : ");
		a = sc.nextInt();
		System.out.print("�Ѻ��� ���� : ");
		b = sc.nextInt();
		result = a*b;
		System.out.printf("�簢������ : %d\n", result);}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println();
			System.out.println("1.��  2.�ﰢ��  3.�簢��  0.����");
			int sel = sc.nextInt();
			
			switch(sel) {
			case 0 : System.out.println("�����մϴ�."); 
					return;		// ���⼭ �Լ� ����
			case 1 : circle(); 
					break;
			case 2 : triangle(); 
					break;
			case 3 : rectangle(); 
					break;
			default : System.out.println("���ڸ� �ٽ� �Է��ϼ���.");}
			}
		
	}
}

