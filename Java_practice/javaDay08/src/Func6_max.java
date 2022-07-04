

import java.util.Scanner;

public class Func6_max {
	// 최대값, 최대값의 방넘버 호출하는 함수 생성
	public static int getMax(int[] arr) {
		int i;
		int max = arr[0];	// 배열 안 요소 하나하나
		int maxPos = 0;		// 배열 인덱스 넘버
		for(i=1; i<arr.length; i++) {
			if(max<arr[i]) {
				max = arr[i];
				maxPos = i;}
		} // return max;	// 최대값을 가져오고 싶다면
			 return maxPos;	// 방넘버를 가져오고 싶다면 (**return은 for문이 끝난 후에 써줌)
	}
	
	public static void main(String[] args) {
		int[] num = new int[] {3,21,42,17,2,32};
		System.out.println("인덱스 : " + getMax(num));		// 방넘버 (num=maxpos)
		System.out.println("최대값 : " + num[getMax(num)]);	// 최대값 (num배열안의 n번째 인덱스방의 요소->최대값)
		
	}
}
