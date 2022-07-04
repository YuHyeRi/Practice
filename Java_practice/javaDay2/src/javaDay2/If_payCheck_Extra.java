package javaDay2;

import java.util.Scanner;

public class If_payCheck_Extra {

	public static void main(String[] args) {
		// 1. 입력변수(이름, 근무시간, 시간당급여)
		String name;
		int work_time, per_pay;
		
		// 2. 출력변수(기본급, 수당)
		int pay, over_pay;
		
		Scanner sc = new Scanner(System.in);
		
		// 3. 입력
		System.out.println("이름 : ");
		name = sc.nextLine();
		System.out.println("근무시간 : ");
		work_time = sc.nextInt();
		System.out.println("시급 : ");
		per_pay = sc.nextInt();
		
		// 4. 계산
		pay = work_time * per_pay;
		over_pay = 0;
		if(work_time > 20) {
			over_pay = (work_time - 20) * per_pay / 2;
			
		// 5. 출력
			System.out.printf("%s %d %d %d\n", name, pay, over_pay, pay+over_pay);
		}

	}
}
