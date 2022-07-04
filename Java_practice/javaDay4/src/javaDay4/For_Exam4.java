package javaDay4;

public class For_Exam4 {
	// 연습문제 12
	public static void main(String[] args) {
		
		int i, j;
		int k = 1;
		
		for(i=1; i<=10; i++) {
			for(j=1; j<=i; j++) {
				System.out.printf("%3d", k);
				k++;
			} System.out.println();
		}
		
	}
}
