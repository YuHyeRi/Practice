package javaDay2;

import java.util.Scanner;

public class If_electricityBill {
		// 연습문제 8
	public static void main(String[] args) {
		
		int usage;
		int pay1, pay2, pay3;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("전기사용량은?");
		usage = sc.nextInt();
		
		
		pay1 = usage * 600;
		pay2 = (100*600) + (usage-100) * 700;
		pay3 = ((100*600) + (100*700)) + pay2 + (usage-200) * 800;
	
		if(usage < 100) {
			System.out.println(pay1 + "원");
		} else if(usage >= 100 && usage < 200) {
			System.out.println(pay2 + "원");
		} else if(usage > 200) {
			System.out.println(pay3 + "원");
		}
	}
}
