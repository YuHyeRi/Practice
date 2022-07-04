package javaDay3;

public class Thoery3 {
	// 이중for문
	public static void main(String[] args) {
		
		int i, j;	// 외부와 내부에서 카운트할 변수가 각각 필요
		for(i = 1; i <= 5; i++) {
			for(j = 1; j <= 5; j++) {
				System.out.printf("i=%d j=%d\n", i, j);
			}
		}
		
		for(i = 1; i <= 5; i++) {
			for(j = 1; j <= 10; j++) {
				System.out.printf("%5d",j);		// printf 니까 옆으로 출력됨
			}
			System.out.println();
		}

	}

}
