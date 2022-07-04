package javaDay4;

public class DoWhile_Exam1 {
	// do..while문 : 사용자의 입력을 받을 때 유용(한번은 값을 받아 실행시켜야하니까)
	// do..while문으로 1~10까지 출력하기
	public static void main(String[] args) {
		
		int i = 1;
		do {
			System.out.printf("%3d", i);
			i++;
		} while(i<11);
		
	}
}
