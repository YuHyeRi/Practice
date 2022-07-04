package com.lotto;

public class Lotto {

	int[] lotto = new int[6];
	int cnt = 0;	// 로또번호 6개 생성되었는지 카운트
	boolean isDuplicate(int key) {
		for(int i=0; i<cnt; i++) {
			if(lotto[i] == key)
				return true;
		} return false;
	}
	
	public void start() {
		while(cnt < 6) {
			int num = (int)(Math.random()*10) + 1;	// 1~10까지 랜덤추출
			if(!isDuplicate(num)) {				// 중복안되었을때만
				lotto[cnt] = num;
				cnt++;
			}
		} for(int i=0; i<cnt; i++) 
			System.out.printf("%4d", lotto[i]);
			System.out.println();
	}
}
