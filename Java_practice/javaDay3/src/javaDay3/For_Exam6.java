package javaDay3;

public class For_Exam6 {
	// 순차대로 더하기 문제
	public static void main(String[] args) {
		
		int i, j, k;
		
		for(i = 1; i <= 10; i++) {
			k = 0;	// 계속 1부터 더하기 때문에 초기화해줌
			for(j = 1; j <= i; j++) {
				System.out.printf("%d", j);
				if(j != i)
					System.out.print(" + ");
				k = k + j;
			}
			System.out.printf(" = %d\n", k);
		}
		
	}	// main
}	// class
