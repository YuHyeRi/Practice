package javaDay5;

import java.io.IOException;

public class String3_toInt {
		// 문자열 -> 숫자 변환하기
	public static void main(String[] args) throws IOException {
		// System.in.read() : 콘솔창에 입력되는 값은 모두 아스키코드 값으로 입력 받음(0~255)
		// 따라서, char형으로 받고 싶다면 형변환이 필요함
		// 문자 A를 입력 받으면, 아스키코드값인 65가 입력
		// 숫자 0을 입력받으면, 아스키코드값인 48이 입력
		
		String a = "2";
		String b = "3";
		int result;
		
		// 1. Integer.parseInt()
		result = Integer.parseInt(a) + Integer.parseInt(b);
		System.out.println("1. 합계는 " + result+ " 입니다.");
		
		// 2. Integer.valueOf()
		result = Integer.valueOf(a) + Integer.valueOf(b);
		System.out.println("2. 합계는 " + result + " 입니다.");
		
		// 3. Integer.toString()
		// 숫자를 문자로 바꿔줌
		
	}
}
