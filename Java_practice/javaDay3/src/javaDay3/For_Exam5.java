package javaDay3;

public class For_Exam5 {
	// 알파벳 짜집기 문제
	public static void main(String[] args) {
		
		int i, j;		// 아스키코드 숫자로 함
		char k;
		
		for(i = 0; i < 26; i++) {
			k = (char) ('A' + i);
			for(j = 0; j < 26; j++) {
			System.out.printf("%c", k);
			k++;
			if(k > 'Z') {
				k = 'A';
			}
			}
			System.out.println();
		}
	
	}	// main
}	// class
