package javaDay4;

public class While_Exam2 {
	// 1 ~ n까지의 정수 중, 그 합산이 1000이 넘는 최초의 n 값을 구하라.
	public static void main(String[] args) {
	
		int num = 0;
		int sum = 0;
		
		while(sum<1000) {
			num+=1;
			sum+=num;
		} System.out.printf("n번째숫자 = %d\n총합계 = %d\n", num, sum);
		
		
		
	}
}
