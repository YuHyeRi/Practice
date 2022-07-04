package javaDay3;

public class For_Exam4 {

	public static void main(String[] args) {
		// 1~100까지 숫자 출력하고, 10개씩 줄바꿈하기
		// 생각보다 유용한 코드니 잘 볼 것!!
		
		int i, j;
		int k = 1;
		
		for(i = 1; i <= 10; i++) {		// 10번 반복
			for(j = 1; j <= 10; j++) {	// 10번 반복이니 총 100번 반복됨
				System.out.printf("%5d", k);
				// System.out.printf("%5d", (i-1)*10 + j);
				// 이렇게 해도 되지만, 오래걸리니 지양
				k++;
				}
			System.out.println();
		}
	}

}
