package javaDay6;

import java.util.Scanner;

public class Exam1 {

	public static void main(String[] args) {
		
		int start, end;
		int i, j;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("시작단 입력 : ");
		start = sc.nextInt();
		System.out.print("종료단 입력 : ");
		end = sc.nextInt();
		
		if(start < end) {
			for(i=start; i<=end; i++) {
				System.out.println(i + "단");
				for(j=1; j<10; j++) {
					System.out.println(i + "X" + j + "=" + i*j);
				} System.out.println();
			}
		} else {
			for(i=start; i>=end; i--) {
				System.out.println(i + "단");
				for(j=1; j<10; j++) {
					System.out.println(i + "X" + j + "=" + i*j);
				} System.out.println();
			}
		}
		
		
	}
}
