package javaDay3;

public class For_Exam2 {

	public static void main(String[] args) {
		
		// 숫자 출력하기
		int i;
		for(i = 1; i <= 100; i++) {
			System.out.printf("%4d", i);
			if(i%10 == 0)
				System.out.println();}
		
		System.out.println();
		
		// 알파벳 출력하기
		int j;
		char k = 'A';
		for(j = 1; j <= 100; j++) {
			System.out.printf("%4c", k);
			k++;
			if(k > 'Z') {
			   k = 'A';
			}
			if(j%10 == 0)
				System.out.println();}
		
					
	}	// main
}	// class
