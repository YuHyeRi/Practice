

import java.util.Scanner;

public class Func6_max {
	// �ִ밪, �ִ밪�� ��ѹ� ȣ���ϴ� �Լ� ����
	public static int getMax(int[] arr) {
		int i;
		int max = arr[0];	// �迭 �� ��� �ϳ��ϳ�
		int maxPos = 0;		// �迭 �ε��� �ѹ�
		for(i=1; i<arr.length; i++) {
			if(max<arr[i]) {
				max = arr[i];
				maxPos = i;}
		} // return max;	// �ִ밪�� �������� �ʹٸ�
			 return maxPos;	// ��ѹ��� �������� �ʹٸ� (**return�� for���� ���� �Ŀ� ����)
	}
	
	public static void main(String[] args) {
		int[] num = new int[] {3,21,42,17,2,32};
		System.out.println("�ε��� : " + getMax(num));		// ��ѹ� (num=maxpos)
		System.out.println("�ִ밪 : " + num[getMax(num)]);	// �ִ밪 (num�迭���� n��° �ε������� ���->�ִ밪)
		
	}
}
