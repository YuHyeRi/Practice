package javaDay6;

import java.util.Scanner;

public interface Array3_overflow1underflow_QQ {
	// �Է°�(����, ȸ��Ƚ��) �ְ� �迭�� ������ ȸ���ϱ�
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int a[] = new int[] {1,2,3,4,5,6,7,8,9};
		int i, k;
		int overFlow, underFlow;
		
		System.out.print("���� (L:Left, R:Right) : ");
		String direct = sc.next();
		System.out.print("ȸ��Ƚ�� : ");
		int rotateCnt = sc.nextInt();
		
		if(direct.equals("L") || direct.equals("l")) {
			for(k=1; k<=rotateCnt; k++) {	// �Էµ� ȸ������ŭ �ݺ��Ұǵ�
				overFlow = a[0];			// 0���� �ε����� �ִ°� �ϴ� ���
				for(i=1; i<a.length; i++) {	// 1���� �����ϰ�
					a[i-1] = a[i];			// ��ĭ�� �������� ����
				} a[a.length-1] = overFlow; // �Ʊ� ��Ҵ��� �� �����ٰ� ��
			}
		}
		else {
			for(k=1; k<=rotateCnt; k++) {
				underFlow = a[a.length-1];	// �� �� �ε����� �ִ°� �ϴ� ���
				for(i=a.length-1; i>0; i--) {	// a.length-1 : ������ ��(��ȣ)
					a[i] = a[i-1];			// ��ĭ�� ���������� ����
				} a[0] = underFlow;			// �Ʊ� ��Ҵ��� �� �տ��� ��
			}
		}
		for(i=0; i<a.length; i++) {
			System.out.printf("%3d", a[i]);
		}
		System.out.println();
		
		
	}
}
