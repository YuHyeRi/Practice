package javaDay3;

public class For_Exam4 {

	public static void main(String[] args) {
		// 1~100���� ���� ����ϰ�, 10���� �ٹٲ��ϱ�
		// �������� ������ �ڵ�� �� �� ��!!
		
		int i, j;
		int k = 1;
		
		for(i = 1; i <= 10; i++) {		// 10�� �ݺ�
			for(j = 1; j <= 10; j++) {	// 10�� �ݺ��̴� �� 100�� �ݺ���
				System.out.printf("%5d", k);
				// System.out.printf("%5d", (i-1)*10 + j);
				// �̷��� �ص� ������, �����ɸ��� ����
				k++;
				}
			System.out.println();
		}
	}

}
