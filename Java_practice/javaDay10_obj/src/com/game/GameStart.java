package com.game;

import java.util.Scanner;

public class GameStart {
	
	// 1. start, again �޼ҵ�
	public void start() {
		Scanner sc = new Scanner(System.in);
		int again;
		
		while(true) {
			System.out.printf("���ӽ���!\n1.����  2.����  3.��\n");
			int user = sc.nextInt();
			System.out.println();
			GameData g1 = new GameData(user);
			g1.output();
			
			System.out.println();
			
			System.out.printf("����ϽǷ���?\n1.��  2.�ƴϿ�\n");
			again = sc.nextInt();
			
			if(again!=1)
				break;
		}
	}
}
