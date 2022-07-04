package javaDay2;

import java.util.Scanner;

public class If_electricityBill_Extra {
		// 연습문제 8
	public static void main(String[] args) {
		
		int kw;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("전기사용량은? : ");
		kw = sc.nextInt();
		
		final int LEVEL1 = 600;
		final int LEVEL2 = 700;
		final int LEVEL3 = 800;
		
		int fee = 0;
		if(kw < 100) {
			fee = kw * LEVEL1;
		} else if(kw < 200) {
			fee = 100*600 + (kw-100) * LEVEL2;
		} else if(kw < 300) {
			fee = 100*600 + 100*700 + (kw-200)*LEVEL3;
		}
		System.out.printf("전기요금 : %d원", fee);
	}

}
