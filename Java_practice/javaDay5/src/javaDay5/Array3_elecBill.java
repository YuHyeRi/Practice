package javaDay5;

import java.util.Scanner;

public class Array3_elecBill {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 입력변수 : 전기총사용금액, 가구당 전기사용량, 총사용량
		// 출력 : 가구별 전기요금
		
		int total_fee=0;
		int total_use=0;
		int house_use[] = new int[5];
		int house_fee[] = new int[5];
		int fee = total_fee/total_use;
		int i;
		
		System.out.print("총사용량 : ");
		total_use = sc.nextInt();
		
		System.out.print("전기요금 : ");
		total_fee = sc.nextInt();
		for(i=0; i<5; i++) {
			System.out.printf("각 가구당 요금 : %d호 ", (i+1));
			house_use[i] = sc.nextInt();
		}
		
		// 계산
		for(i=0; i<5; i++) {
			house_fee[i] = house_use[i]*fee;
		}
		
		// 출력하기
		for(i=0; i<5; i++) {
			System.out.printf("%d ==> %d\n", house_fee[i], house_use[i]);
		}
		
		
	}//main
}//class
