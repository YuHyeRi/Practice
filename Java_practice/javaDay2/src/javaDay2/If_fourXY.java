package javaDay2;

import java.util.Scanner;

public class If_fourXY {
	
	public static void main(String[] args) {
		
		int x, y;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("x의 좌표 : ");
		x = sc.nextInt();
		System.out.println("y의 좌표 : ");
		y = sc.nextInt();
		
		if(x>0 && y>0) {
			System.out.println("1사분면");
		} else if(x<0 && y>0) {
			System.out.println("2사분면");
		} else if(x<0 && y<0) {
			System.out.println("3사분면");
		} else if(x>0 && y<0) {
			System.out.println("4사분면");
		} else if(x==0 && y==0) {
			System.out.println("원점");
		}
		
	}	// main
}	// class
