package javaDay3;

import java.util.Scanner;

public class For_Exam1 {
	
	public static void main(String[] args) {

		System.out.println("1. 짝수출력");
		int i;
		for(i = 2; i <= 10; i+=2) {		// += 이렇게 쓸 수도 있음
			System.out.printf("%3d", i);	// 숫자 하나 내보낼때 3칸을 확보해라
			// printf("%3d" : 가로로 출력, 숫자 하나 당 3칸씩 차지(한자리수면 두칸 띄고 한자리쓰고..이런식)
		}
		System.out.println();
		System.out.println("==============================");

		System.out.println("2. 홀수출력");
		int j;
		for(j = 1; j <= 20; j+=2) {
			System.out.printf("%3d", j);
		}
		System.out.println();
		System.out.println("==============================");

		System.out.println("3. 3의 배수 10개 내보내기");
//		int z;
//		for(z = 3; z <= 30; z+=3) {
//			System.out.printf("%3d", z);
//		}
		int k = 3;						// 변수선언 하나 더 해서
		for(i = 1; i <= 10; i++) {			// 얘는 그냥 10번 카운트만 하고
			System.out.printf("%3d", k);
			k+=3;						// k = k+3 반복
		}
		System.out.println();
		System.out.println();
		System.out.println("==============================");
		
		System.out.println("4. 단어, 횟수 입력받아서 출력하기");
		
		Scanner sc = new Scanner(System.in);
		
		String str;
		int num, count;
		
		System.out.println("단어 : ");
		str = sc.nextLine();
		System.out.println("반복횟수 : ");
		count = sc.nextInt();
		
		for(num = 1; num <= count; num++) {
			System.out.println(str);
		}
		

	}	// main
}	// class