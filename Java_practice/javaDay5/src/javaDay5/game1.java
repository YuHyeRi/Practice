package javaDay5;

import java.util.Scanner;

public class game1 {
	// Math.random() 함수
	// 가위 바위 보 게임
	public static void main(String[] args) {
		
		//int i;
		//for(i=0; i<=10; i++) {
			// System.out.println(Math.random());	// 0 ~ 1 사이의 랜덤한 실수 출력
			// System.out.println((int)(Math.random()*10));	// 0 ~ 9 사이의 랜덤한 정수 출력
			// System.out.println((int)(Math.random()*3+1));} 	// 1 ~ 3 사이의 랜덤한 정수 출력
			
		Scanner sc = new Scanner(System.in);
		
		int user;
		int comp;
		String winner;
		String replay;
		
		do {
		System.out.println("Game Start? (1가위, 2바위, 3보)");
		
		user = sc.nextInt();
		comp = (int)(Math.random()*3+1);
		
		if(comp == 1) {
			if(user == 2) {
				winner = "이겼습니다:)";
			} else if(user == 3) {
				winner = "졌습니다TT";
			} else {
				winner = "무승부!";
			}
		} else if(comp == 2) {
			if(user == 3) {
				winner = "이겼습니다:)";
			} else if(user == 1) {
				winner = "졌습니다TT";
			} else {
				winner = "무승부!";
			}
		} else {
			if(user == 1) {
				winner = "이겼습니다:)";
			} else if(user == 2) {
				winner = "졌습니다TT";
			} else {
				winner = "무승부!";
			}
		}
		
		System.out.println("결과 : " + winner);
		System.out.printf("당신이낸값 : %d, 컴퓨터가낸값 : %d\n", user, comp);
		
		System.out.println();
		
		System.out.println("게임을 다시 하실래요?(Y/N)");
		replay = sc.next();
		} while(replay.equals("Y")||replay.equals("y"));
		System.out.println("Game Over");
		
		
	}
}
