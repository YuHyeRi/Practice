package javaDay2;

import java.util.Scanner;

public class If_payCheck_Extra {

	public static void main(String[] args) {
		// 1. �Էº���(�̸�, �ٹ��ð�, �ð���޿�)
		String name;
		int work_time, per_pay;
		
		// 2. ��º���(�⺻��, ����)
		int pay, over_pay;
		
		Scanner sc = new Scanner(System.in);
		
		// 3. �Է�
		System.out.println("�̸� : ");
		name = sc.nextLine();
		System.out.println("�ٹ��ð� : ");
		work_time = sc.nextInt();
		System.out.println("�ñ� : ");
		per_pay = sc.nextInt();
		
		// 4. ���
		pay = work_time * per_pay;
		over_pay = 0;
		if(work_time > 20) {
			over_pay = (work_time - 20) * per_pay / 2;
			
		// 5. ���
			System.out.printf("%s %d %d %d\n", name, pay, over_pay, pay+over_pay);
		}

	}
}
