package javaDay4;

import java.util.Scanner;

public class Break_Exam1 {
	// for, while, do~while, switch ���� ������ ����
	// if�� ��ü�� break�� ������ ���� ����
	// ����, ����for�� �� ���, ���� loop���� break�� ����ϸ�, ���� loop�� ��������.(���ÿ� �ܺ� loop���� ������X)
	// ������ ���� ��� ���ϴ� ���� ����
	public static void main(String[] args) {
		
		/* �̷��� ������ ������ �� �Ⱦ���.
		int i = 1;
		for( ; ; ) // ���ѷ��� = break���� ¦����� �Ѵ�.
		{
			System.out.println(i);
			i=i+1;
			if(i>10) break;
		}
		*/
		
		// ���� �дٰ� ���� ������ ���߱�
		int num;
		int sum=0;
		
		Scanner sc = new Scanner(System.in);
		
		for(;;) {
			System.out.print("�����Է� : ");
			num = sc.nextInt();
			if(num<0) {		// �Է°��� ������
				break;		// break;
			}
			sum+=num;		// �׳� ����ó�� �ܿ���.. �Էµ� �� ��� �����ִ°�!!
		} System.out.println("�Էµ� ������ �հ� : " + sum);
		
	}
}
