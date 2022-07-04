package javaDay1;

import java.util.Scanner;

public class Java_dutchPay {
	// 연습문제 10
	public static void main(String[] args) {
		
		int a, b, c;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("김치찌개 : ");
		a = sc.nextInt();
		System.out.println("된장찌개 : ");
		b = sc.nextInt();
		System.out.println("제육볶음 : ");
		c = sc.nextInt();
		
		int aPrice = a * 5000;
		int bPrice = b * 4000;
		int cPrice = c * 6000;
		int totalPrice = aPrice + bPrice + cPrice;
		int personalPrice = totalPrice/5;

		System.out.println("주문내용 : " + "김치찌개" + a + " 된장찌개" + b + " 제육볶음" + c);
		System.out.println("더치페이 금액 : " + personalPrice);

	}

}
