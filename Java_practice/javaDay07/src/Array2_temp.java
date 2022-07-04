

import java.util.Scanner;

public class Array2_temp {
	// 최고온도(&시간), 최저온도(&시간), 평균온도 구하기
	public static void main(String[] args) {
		
		final int HOUR = 6;
		int temp[] = new int[HOUR];	
		int maxTemp, minTemp;
		int maxPos, minPos;
		int sum = 0;
		int cnt = 0;
		
		Scanner sc = new Scanner(System.in);
		
		// 1. 입력값 받기
		for(int i=0; i<temp.length; i++) {
			System.out.printf("%d시 : ", i+1);
			temp[i] = sc.nextInt();	
		}
		
		// 2. 계산하기
		for(int i=0; i<temp.length; i++) {
			sum+=temp[i];
			cnt++;
		}
		
		// 3. 최고온도 구하기
		maxTemp = temp[0];
		maxPos = 1;
		for(int i=1; i<temp.length; i++) {
			if(maxTemp<temp[i]) {
				maxTemp = temp[i];
				maxPos = i+1;
			}
		}
		
		// 4. 최저온도 구하기
		minTemp = temp[0];
		minPos = 1;
		for(int i=1; i<temp.length; i++) {
			if(minTemp>temp[i]) {
				minTemp = temp[i];
				minPos = i+1;
			}
		}
		
		// 5. 출력하기
		System.out.printf("최고온도:%d도(%d시)\n최저온도:%d도(%d시)\n ==> 평균온도:%d도", 
							maxTemp, maxPos, minTemp, minPos, (sum/cnt));
		
		
	}
}
