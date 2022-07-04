package javaDay4;

import java.util.Scanner;

public class Break_Exam1 {
	// for, while, do~while, switch 문은 영향을 받음
	// if문 자체는 break의 영향을 받지 않음
	// 만약, 이중for문 일 경우, 내부 loop에서 break를 사용하면, 내부 loop만 빠져나옴.(동시에 외부 loop까지 빠지진X)
	// 가급적 많이 사용 안하는 것이 좋음
	public static void main(String[] args) {
		
		/* 이렇게 쓸수도 있지만 잘 안쓴다.
		int i = 1;
		for( ; ; ) // 무한루프 = break문과 짝지어야 한다.
		{
			System.out.println(i);
			i=i+1;
			if(i>10) break;
		}
		*/
		
		// 정수 읽다가 음수 들어오면 멈추기
		int num;
		int sum=0;
		
		Scanner sc = new Scanner(System.in);
		
		for(;;) {
			System.out.print("정수입력 : ");
			num = sc.nextInt();
			if(num<0) {		// 입력값이 음수면
				break;		// break;
			}
			sum+=num;		// 그냥 공식처럼 외워라.. 입력된 값 계속 합쳐주는것!!
		} System.out.println("입력된 정수의 합계 : " + sum);
		
	}
}
