package javaDay2;

import java.util.Scanner;

public class If_tax {
	// 연습문제 9
	public static void main(String[] args) {
		
		int salary, tax;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("근로소득세 계산기");
		System.out.println("연봉 : ");
		salary = sc.nextInt();
		
		double tax1, tax2, tax3, tax4;
		tax1 = salary * 0.06;
		tax2 = 720000 + ((salary-12000000)*0.15);
		tax3 = 5820000 + ((salary-46000000)*0.24);
		tax4 = 15920000 + ((salary-88000000)*0.35);
		
		if(salary < 12000000) {
			System.out.println(tax1);
		} else if(salary <= 46000000) {
			System.out.println(tax2);
		} else if(salary <= 88000000) {
			System.out.println(tax3);
		} else {
			System.out.println(tax4);
		}
		
	}
}
