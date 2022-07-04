package javaDay4;

import java.util.Scanner;

public class Exam1 {
	// 성별, 연봉 입력받아 각 성별별 평균연봉 구하고, 성별로 Z가 들어오면 종료
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		char gender;
		int income;
		int mSum = 0;
		int mCnt = 0;
		int fSum = 0;
		int fCnt = 0;
		
		do {
			System.out.print("성별 : ");
			gender = sc.next().charAt(0);
			
			switch(gender) {
			case 'M' :
			case 'm' :
				System.out.print("연봉 : ");
				income = sc.nextInt();
				mSum+=income;
				mCnt++;
				break;
			case 'F' : 
			case 'f' :
				System.out.print("연봉 : ");
				income = sc.nextInt();
				fSum+=income;
				fCnt++;
				break;
			case 'Z' : 
			case 'z' :
				System.out.print("Z가 입력되어 종료합니다.");
				System.out.println();
				break;
			default : 
				System.out.println("알맞은 알파벳을 넣어주세요.");
			}
		} while (gender != 'Z' && gender != 'z');
		
		if(mCnt != 0) {
			System.out.printf("남성의 평균연봉은 %d만원 입니다.\n", mSum/mCnt);
		}
		if(fCnt != 0) {
			System.out.printf("여성의 평균연봉은 %d만원 입니다.\n", fSum/fCnt);
		}
		if(mCnt == 0 && fCnt == 0) {
			System.out.println("값을 입력하세요.\n");
		}
		
		
	}
}
