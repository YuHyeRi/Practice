package javaDay2;

import java.util.Scanner;

public class If_fourXY {
	
	public static void main(String[] args) {
		
		int x, y;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("x�� ��ǥ : ");
		x = sc.nextInt();
		System.out.println("y�� ��ǥ : ");
		y = sc.nextInt();
		
		if(x>0 && y>0) {
			System.out.println("1��и�");
		} else if(x<0 && y>0) {
			System.out.println("2��и�");
		} else if(x<0 && y<0) {
			System.out.println("3��и�");
		} else if(x>0 && y<0) {
			System.out.println("4��и�");
		} else if(x==0 && y==0) {
			System.out.println("����");
		}
		
	}	// main
}	// class
