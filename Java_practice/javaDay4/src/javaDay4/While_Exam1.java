package javaDay4;

public class While_Exam1 {

	public static void main(String[] args) {
		
		// ¦�� ���
		int i = 2;
		while(i<=10) {
			System.out.printf("%3d", i);
			i+=2;
		} System.out.println();		// �׳� �ٹٲ��Ϸ��� ��
		
		// Ȧ�� ���
		int j = 1;
		while(j<=10) {
			System.out.printf("%3d", j);
			j+=2;
		} System.out.println();
		
		// 90, 80, 70,... ���
		int k = 90;
		while(k>0) {
			System.out.printf("%3d", k);
			k-=10;
		}
		
	}
}
