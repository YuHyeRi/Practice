

public class Array1_max1min {
	// �迭 �� �ִ밪, �ּҰ� ã��
	public static void main(String[] args) {

		int arr[] = new int[] {4,56,101,23,45,45};	// �迭 ����
		int max, min;	// �ִ밪, �ּҰ� ���� ����
		int maxpos, minpos;	// ���° �迭(��)�� �ִ��� ���� ���� ���� ����
		
		// 1. �ִ밪 ã��
		max = arr[0];	// �ִ밪 ������ 0��° �ε��� �� ���
		maxpos = 0;
		for(int i=0; i<arr.length; i++) {
			if(max<arr[i]) {		// arr�� �ѹ��� ���鼭, ���� 0��° �ε��� ������ ũ�ٸ�
				max = arr[i];		// max�� �ε��� �� ���� ū ���� ���
				maxpos = i;			// ���° �ε������� maxpos�� ��´�
			}
		} System.out.printf("�ִ밪 : %d\n", max);
		System.out.printf(" ==> �ε��� : %d\n", maxpos);
		
		
		// 2. �ּҰ� ã��
		min = arr[0];
		minpos = 0;
		for(int i=0; i<arr.length; i++) {
			if(min>arr[i]) {
				min = arr[i];
				minpos = i;
			}
		} System.out.printf("�ּҰ� : %d\n", min);
		System.out.printf(" ==> �ε��� : %d\n", minpos);
		
		
	}
}
