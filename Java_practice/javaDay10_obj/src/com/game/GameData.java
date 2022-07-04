package com.game;

public class GameData {
	
	int comp, user;
	int winner;		// 1.��ǻ�ͽ� 2.����� 3.���º�
	
	// 1. ������
	public GameData(int user) {
		comp = (int)(Math.random()*3+1);
		this.user = user;
		winner = whoIsWinner();
	}
	
	// 2. ��� �޼ҵ�
	int whoIsWinner() {
		if(comp == user)
			return 3;		// ���º��� ���, 3�� ����
		if(comp == 1 && user==3 ||  comp ==2 && user==1 || comp ==3 && user==2)
			return 1;		// ��ǻ�ͽ��� ���, 1�� ����
		return 2;			// �׿�(�����)�� ���, 2�� ����
	}
	
	// 3. ��� �޼ҵ�
	public void output() {
		String[] msg1 = new String[] {"", "����", "����", "��"};			// 1,2,3 �Է��̴ϱ� 0�� ���� ����α�
		String[] msg2 = new String[] {"", "��ǻ�ͽ�TT", "�����!", "���º�"};// 1,2,3 �Է��̴ϱ� 0�� ���� ����α�
		System.out.printf("��ǻ�� : %s\n��� : %s\n��� : %s\n", msg1[comp], msg1[user], msg2[winner]);
	}
	
}