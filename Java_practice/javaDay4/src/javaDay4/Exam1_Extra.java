package javaDay4;

import java.util.Scanner;

public class Exam1_Extra {
	// 연봉, 평균 구하기
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 1. 데이터 입력자료 : 성별, 연봉
		// 2. 데이터 출력자료 : 평균
		// 3. 그 밖의 변수들 : 성별별 합계, 성별별 카운트
		
		char gender;
		double yearPay;
		double mSum = 0;	// 필요한 변수들의 초기화
		double fSum = 0;	// 필요한 변수들의 초기화
		int mCnt = 0;	// 필요한 변수들의 초기화
		int fCnt = 0;	// 필요한 변수들의 초기화
		
		System.out.print("성별 : ");
		gender = sc.next().charAt(0);
		
		System.out.print("연봉 : ");
		yearPay = sc.nextDouble();
		
		// 이런식으로 앞에 !을 붙여서 쓸 수도 있음		
		while(!(gender == 'Z' || gender == 'z')) {
			if(gender == 'M' || gender == 'm') {
				mSum+=yearPay;
				mCnt++;
			} else {
				fSum+=yearPay;
				fCnt++;
			}
			System.out.print("성별 : ");
			gender = sc.next().charAt(0);
			
			System.out.print("연봉 : ");
			yearPay = sc.nextDouble();
		}
		
		if(mCnt!=0) {
			System.out.printf("남성평균연봉 : %.1f 만원\n", mSum/mCnt);
		}
		if(fCnt!=0) {
			System.out.printf("여성평균연봉 : %.1f 만원\n", fSum/fCnt);
		}
		
	}
}
