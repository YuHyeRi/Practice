package javaDay3;

public class For_Exam6 {
	// ������� ���ϱ� ����
	public static void main(String[] args) {
		
		int i, j, k;
		
		for(i = 1; i <= 10; i++) {
			k = 0;	// ��� 1���� ���ϱ� ������ �ʱ�ȭ����
			for(j = 1; j <= i; j++) {
				System.out.printf("%d", j);
				if(j != i)
					System.out.print(" + ");
				k = k + j;
			}
			System.out.printf(" = %d\n", k);
		}
		
	}	// main
}	// class
