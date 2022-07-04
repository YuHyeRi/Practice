package com.game;

import java.util.Scanner;

public class GameStart {
	
	// 1. start, again 메소드
	public void start() {
		Scanner sc = new Scanner(System.in);
		int again;
		
		while(true) {
			System.out.printf("게임시작!\n1.가위  2.바위  3.보\n");
			int user = sc.nextInt();
			System.out.println();
			GameData g1 = new GameData(user);
			g1.output();
			
			System.out.println();
			
			System.out.printf("계속하실래요?\n1.네  2.아니오\n");
			again = sc.nextInt();
			
			if(again!=1)
				break;
		}
	}
}
