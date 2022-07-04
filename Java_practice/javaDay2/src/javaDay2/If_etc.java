package javaDay2;

import java.util.Scanner;

public class If_etc {

	public static void main(String[] args) {
		
	 int a, b;
	 
	 Scanner sc = new Scanner(System.in);
	 
	 System.out.println("숫자1 : ");
	 a = sc.nextInt();
	 System.out.println("숫자2 : ");
	 b = sc.nextInt();
	 
	 if(a > b) {
		 System.out.println(a);
	 } else {
		 System.out.println(b);
	 }
		

	}

}
