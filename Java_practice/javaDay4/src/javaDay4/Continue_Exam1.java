package javaDay4;

public class Continue_Exam1 {
	// continue 이용해서 1~10까지 숫자 출력하기(6제외하고)
	public static void main(String[] args) {
		
		int i;
		for(i=1; i<=10; i++) {
			if(i==6)
				continue;
			System.out.printf("%3d",i);
		}
		
	}
}
