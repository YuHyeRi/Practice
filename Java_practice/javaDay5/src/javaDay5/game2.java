package javaDay5;

import java.util.Scanner;

public class game2 {
	// 4������ ���� ���߱� ����
	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
	
	int user, comp;
	int cnt;
	int totalGameCnt = 0;
	int correctCnt = 0;
	final int TOTALCNT = 4;
	boolean flag;	// t:����, f:������
	String replay;
	
	do {
		// �� ���� �ʱ�ȭ do�� �ȿ��� ���ִ� �� ����ϱ�
		cnt = 0;
		flag = false;
		
		comp = (int)(Math.random()*9+1);	// 1 ~ 9 ������ ���� ���
		
		while((cnt<TOTALCNT) && flag == false) {
			System.out.println("�����Է� :");
			user = sc.nextInt();
			
			if(user>comp) {
				System.out.println("�� ���� ���ڸ� �Է��ϼ���TT");
			} else if(user<comp) { 
				System.out.println("�� ū ���ڸ� �Է��ϼ���TT");
			} else {
				System.out.println("�����Դϴ�!");
				flag = true;
			}
			cnt++;
		} //while�� ����
		
		if(flag == true) {
			System.out.printf("%d��° ���߾����ϴ�.\n", cnt);
			correctCnt++;	// ������ ��� ����
		} else {
			System.out.printf("%d���� ��ȸ�� ��� ����߳׿�\n", TOTALCNT);
		} totalGameCnt++; // ��ü ����
		
		System.out.println("����ϽǷ���? (Y/N)");
		replay = sc.next();
	} // do..while�������� do�� ����
	
	while(replay.equals("Y")||replay.equals("y")); // do..while�������� while�� ����
	
	System.out.println("������ �����մϴ�.");
	System.out.printf("����� %d�� ������ �߰�, %d�� ������ ������ϴ�!\n", totalGameCnt, correctCnt);
	
	
	}//main
}//class
