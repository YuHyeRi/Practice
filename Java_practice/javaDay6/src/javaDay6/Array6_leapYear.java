package javaDay6;

import java.util.Scanner;

public class Array6_leapYear {
	// 배열이용하여 윤년, 전체일수 출력하기
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] days = new int[] {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		System.out.print("년도입력 : ");
		int year = sc.nextInt();
		System.out.print("월 입력 : ");
		int month = sc.nextInt();
		System.out.print("일 입력 : ");
		int day = sc.nextInt();
		
		if(year%4 == 0 && year%100 != 0 || year%400 == 0) {
			days[2] = 29;	// 윤년일 경우, 2월달을 29일로 변경
		}
		
		int totalDays = 0;
		for(int i = 1; i<month; i++) {	// ex. 7월 5일을 구하는거라면, 6월 말까지 더해야하니까 (=<가 아닌 <)
			totalDays+=days[i];	// 7월5일이면 6월말까지 더한 값
		} 
		totalDays+=day;	// 7월5일이면 나머지 5일을 더한 값
		System.out.println(" ==>" + year + "년이 시작된지 " + totalDays + "일째");
		
	}
}
