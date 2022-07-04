package com.updown;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UpdownGame {
	// List는 부모클래스 -> 상속받아서 ArrayList가 만들어진다.
	// <> : 여기에 담을 것을 쓴다, 밑의 경우에는 UpdownData이라는 class를 담은 것.
	List<UpdownData> list = new ArrayList<UpdownData>();
	
	// 굳이 생성자 없이 함수만 쓰는 경우도 있음
	public void start() {
		int again;
		do {
			UpdownData u1 = new UpdownData();
			u1.start();		// 게임 한판 끝나고
			list.add(u1);	// 그 게임에 대한 정보를 저장해서 list에 담음
			
			Scanner sc = new Scanner(System.in);
			System.out.println();
			System.out.println("게임을 다시 할까요? 1.네  2.아니오");
			again = sc.nextInt();
		} while(again == 1);
		output();
	}
	
	// 메서드
	public void output() {
		for(int i=0; i<list.size(); i++) {
			UpdownData u1 = list.get(i);	// 저장된 데이터 가져오기
			System.out.printf("컴퓨터 : %d\n", u1.getComp());
			
			for(int j=0; j<u1.getNumbers().length; j++)
				System.out.printf("%4d", u1.getNumbers()[j]);	// 사용자가 지금까지 입력한 숫자 출력
			System.out.println();
			for(int k=0; k<u1.getUpdown().length; k++)
				System.out.printf("%4d", u1.getUpdown()[k]);	// 1.up 2.down 3.match
			System.out.println();
		}
	}
	
}