package javaDay4;

public class While_Exam2 {
	// 1 ~ n������ ���� ��, �� �ջ��� 1000�� �Ѵ� ������ n ���� ���϶�.
	public static void main(String[] args) {
	
		int num = 0;
		int sum = 0;
		
		while(sum<1000) {
			num+=1;
			sum+=num;
		} System.out.printf("n��°���� = %d\n���հ� = %d\n", num, sum);
		
		
		
	}
}
