package com.game;

public class GameData {
	
	int comp, user;
	int winner;		// 1.컴퓨터승 2.사람승 3.무승부
	
	// 1. 생성자
	public GameData(int user) {
		comp = (int)(Math.random()*3+1);
		this.user = user;
		winner = whoIsWinner();
	}
	
	// 2. 계산 메소드
	int whoIsWinner() {
		if(comp == user)
			return 3;		// 무승부일 경우, 3을 리턴
		if(comp == 1 && user==3 ||  comp ==2 && user==1 || comp ==3 && user==2)
			return 1;		// 컴퓨터승일 경우, 1을 리턴
		return 2;			// 그외(사람승)일 경우, 2를 리턴
	}
	
	// 3. 출력 메소드
	public void output() {
		String[] msg1 = new String[] {"", "가위", "바위", "보"};			// 1,2,3 입력이니까 0번 방은 비워두기
		String[] msg2 = new String[] {"", "컴퓨터승TT", "사람승!", "무승부"};// 1,2,3 입력이니까 0번 방은 비워두기
		System.out.printf("컴퓨터 : %s\n사람 : %s\n결과 : %s\n", msg1[comp], msg1[user], msg2[winner]);
	}
	
}