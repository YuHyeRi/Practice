package javaDay3;

public class Thoery3 {
	// ����for��
	public static void main(String[] args) {
		
		int i, j;	// �ܺο� ���ο��� ī��Ʈ�� ������ ���� �ʿ�
		for(i = 1; i <= 5; i++) {
			for(j = 1; j <= 5; j++) {
				System.out.printf("i=%d j=%d\n", i, j);
			}
		}
		
		for(i = 1; i <= 5; i++) {
			for(j = 1; j <= 10; j++) {
				System.out.printf("%5d",j);		// printf �ϱ� ������ ��µ�
			}
			System.out.println();
		}

	}

}
