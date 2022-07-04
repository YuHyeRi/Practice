

import java.util.Scanner;

public class Func7_toLower {
	// 소문자 입력받아서 대문자로 출력하기
	public static String toLower(String s) {
		String str = "";
		int i;
		for(i=0; i<s.length(); i++) {
			if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
				str = str + (char)(s.charAt(i) - 32);
			} else {
				str = str + s.charAt(i);
			}
		} return str;
	}
	
	// 대문자 입력받아서 소문자로 출력하기
	public static String toLower2() {
		Scanner sc = new Scanner(System.in);
		int i;
		String input;
		String result2 = "";
		System.out.println("문장을 입력하세요.");
		input = sc.nextLine();
		for(i=0; i<input.length(); i++) {
			if(input.charAt(i)>='A' && input.charAt(i)<='Z') {
				result2 = result2 + (char)(input.charAt(i) + 32);	// 공백을 넣으려면?
			}
		} return result2;
	}
	
	public static void main(String[] args) {
		System.out.println(toLower("i love you"));
		System.out.println(toLower2());
		
	}
}
