package javaDay5;

import java.util.Scanner;

public class Array3_elecBill {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// �Էº��� : �����ѻ��ݾ�, ������ �����뷮, �ѻ�뷮
		// ��� : ������ ������
		
		int total_fee=0;
		int total_use=0;
		int house_use[] = new int[5];
		int house_fee[] = new int[5];
		int fee = total_fee/total_use;
		int i;
		
		System.out.print("�ѻ�뷮 : ");
		total_use = sc.nextInt();
		
		System.out.print("������ : ");
		total_fee = sc.nextInt();
		for(i=0; i<5; i++) {
			System.out.printf("�� ������ ��� : %dȣ ", (i+1));
			house_use[i] = sc.nextInt();
		}
		
		// ���
		for(i=0; i<5; i++) {
			house_fee[i] = house_use[i]*fee;
		}
		
		// ����ϱ�
		for(i=0; i<5; i++) {
			System.out.printf("%d ==> %d\n", house_fee[i], house_use[i]);
		}
		
		
	}//main
}//class
