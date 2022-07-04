package com.updown;

import java.util.Scanner;

public class UpdownData {
	// 변수
	int[] numbers = new int[4];		// 게임이 4번 진행됨
	int[] updown = new int[4];		// 1.up 2.down 3.match
	int user, comp;
	int cnt = 0;
	boolean match = false;
	
	// 게터
	public int[] getNumbers() {
		return numbers;}
	
	public int[] getUpdown() {
		return updown;}
	
	public int getComp() {
		return comp;}
	
	// 메서드
	public void start() {
		comp = (int)(Math.random()*10) + 1;
		
		Scanner sc = new Scanner(System.in);
		
		do {
		System.out.print("숫자 : ");
		user = sc.nextInt();
		numbers[cnt] = user;
		
		if(comp == numbers[cnt]) {
			match = true;
			updown[cnt] = 3;
		} else if(comp > numbers[cnt]) {
			System.out.println("더 큰 수를 입력하세요.");
			updown[cnt] = 1;
		} else {
			System.out.println("더 작은 수를 입력하세요.");
			updown[cnt] = 2;
		} 
		cnt++;
		} while(match == false && cnt < 4);
		
		if(match) 
			System.out.printf("%d번만의 정답!\n", cnt);
		else 
			System.out.println("못맞추셨습니다 TT\n");
	}
	
}