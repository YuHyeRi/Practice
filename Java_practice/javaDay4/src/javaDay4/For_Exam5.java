package javaDay4;

public class For_Exam5 {
	// 연습문제 20
	// a = 'A' + 32 소문자 'a'가 된다.
	public static void main(String[] args) {
		
		String str = "kitty";
		
		/*
		System.out.println(str.charAt(0));	// k
		System.out.println(str.charAt(1));	// i
		System.out.println(str.charAt(2));	// t
		System.out.println(str.charAt(3));	// t
		System.out.println(str.charAt(4));	// y
		*/
		
		String str2 = "";
		int i;
		
		for(i=0; i<str.length(); i++) {
			if(str.charAt(i)>='a' && str.charAt(i)<='z') {
				str2 = str2 + (char)(str.charAt(i)-32);
			} else {
				str2 = str2 + str.charAt(i);
			}
		}
		System.out.println(str2);
		
	}
}
