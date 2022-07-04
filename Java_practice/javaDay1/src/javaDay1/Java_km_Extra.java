package javaDay1;

import java.util.Scanner;

public class Java_km_Extra {

	public static void main(String[] args) {
		
		int inputMeter;
		int meter, kilometer;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("미터를 입력하세요.");
		inputMeter = sc.nextInt();
		
		meter = inputMeter % 1000;
		kilometer = inputMeter / 1000;
		
		System.out.println(kilometer + "km " + meter + "m");

	}

}
