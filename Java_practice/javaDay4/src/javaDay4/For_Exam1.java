package javaDay4;

public class For_Exam1 {
	// ���̾Ƹ�� ���
	public static void main(String[] args) {
		
		int i; //��
		int j; //��
		
		// ���
		for(i=1; i<=5; i++) {
			for(j=1; j<=5-i; j++) {
				System.out.print(" ");
			} for(j=1; j<=2*i-1; j++) {
				System.out.print("*");
			} System.out.println();
		}
		// �ϴ�
		int line = 4;
		for(i=1; i<=4; i++) {
			for(j=1; j<=i; j++) {
				System.out.print(" ");
			} for(j=1; j<=(line-i+1)*2-1; j++) {
				System.out.print("*");
			} System.out.println();
		}
		
				
		// ���̾Ƹ�� 1/4��
		int a, b;
		for(a=1; a<=5; a++) {
			for(b=1; b<=5-a; b++) {
				System.out.print(" ");
			} for(b=1; b<=a; b++) {
				System.out.print("*");
			} System.out.println();
		}
		
		// ���̾Ƹ�� 2/4��
		for(a=1; a<=5; a++) {
			for(b=1; b<=a; b++) {
				System.out.print("*");
			} System.out.println();
		}
		
		
	}
}