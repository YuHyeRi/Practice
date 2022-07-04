package javaDay2;

import java.util.Scanner;

public class If_payCheck {

	public static void main(String[] args) {
		
		int hour, money;
		String name;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("이름을 입력하세요.");
		name = sc.nextLine();
		System.out.println("근무시간을 입력하세요.");
		hour = sc.nextInt();
		System.out.println("시급을 입력하세요.");
		money = sc.nextInt();
		
		int notOver = hour * money;
		int over = notOver + ((hour-20) * (money/2));
		
		if(hour < 20) {
			System.out.println(name + "님의 총급여는 " + notOver + " 원 입니다.");
		} else if(hour > 20) {
			System.out.println(name + "님의 총급여는 " + over + " 원 입니다.");
		}
		
	}
}
