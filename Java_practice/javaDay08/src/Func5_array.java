

import java.util.Scanner;
	// �Լ��� �迭 ���޽�, �迭�� ũ��� �Ƚᵵ �ȴ� ==> Ÿ��[] ������
public class Func5_array {
	
	// 1. �迭 �Է� �Լ� ����
	public static void readArray(int[]arr) {
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<arr.length; i++) {
			System.out.printf("%d��° : ", (i+1));
			arr[i] = sc.nextInt();}		// �Է¹��� ���� arr �迭�� �������� ������
	}
	
	// 2. �迭 ��� �Լ� ����
	public static void writeArray(int[]arr) {	// arr�� �Ű������μ�, �Լ�ȣ��� ���޵Ǵ� ���� �޾ƿ�
		for(int i=0; i<arr.length; i++) {
			System.out.printf("%3d", arr[i]);
		} System.out.println();
	}
	
	public static void main(String[] args) {
		int[] i = new int[3];	// ������ �ȿ� ���� �ִ��� ��
		int[] j = new int[2];	// ������ �ȿ� ���� �ִ��� ��
		
		// 1. �迭 �Է� �Լ� ȣ��
		readArray(i);
		readArray(j);
		
		// 2. �迭 ��� �Լ� ȣ��
		writeArray(i);	// �Է��Լ��� �Ⱦ��� �Էµ� ���� ���� ������ 0 0 0 �� ���
		writeArray(j);	// �Է��Լ��� �Ⱦ��� �Էµ� ���� ���� ������ 0 0   �� ���
	
	}
}
