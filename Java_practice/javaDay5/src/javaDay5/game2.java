package javaDay5;

import java.util.Scanner;

public class game2 {
	// 4번만에 숫자 맞추기 게임
	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
	
	int user, comp;
	int cnt;
	int totalGameCnt = 0;
	int correctCnt = 0;
	final int TOTALCNT = 4;
	boolean flag;	// t:맞춤, f:못맞춤
	String replay;
	
	do {
		// 각 정수 초기화 do문 안에서 해주는 것 기억하기
		cnt = 0;
		flag = false;
		
		comp = (int)(Math.random()*9+1);	// 1 ~ 9 까지의 정수 출력
		
		while((cnt<TOTALCNT) && flag == false) {
			System.out.println("숫자입력 :");
			user = sc.nextInt();
			
			if(user>comp) {
				System.out.println("더 작은 숫자를 입력하세요TT");
			} else if(user<comp) { 
				System.out.println("더 큰 숫자를 입력하세요TT");
			} else {
				System.out.println("정답입니다!");
				flag = true;
			}
			cnt++;
		} //while문 종료
		
		if(flag == true) {
			System.out.printf("%d번째 맞추었습니다.\n", cnt);
			correctCnt++;	// 맞췄을 경우 증가
		} else {
			System.out.printf("%d번의 기회를 모두 사용했네요\n", TOTALCNT);
		} totalGameCnt++; // 전체 증가
		
		System.out.println("계속하실래요? (Y/N)");
		replay = sc.next();
	} // do..while문에서의 do문 종료
	
	while(replay.equals("Y")||replay.equals("y")); // do..while문에서의 while문 종료
	
	System.out.println("게임을 종료합니다.");
	System.out.printf("당신은 %d번 게임을 했고, %d번 정답을 맞췄습니다!\n", totalGameCnt, correctCnt);
	
	
	}//main
}//class
