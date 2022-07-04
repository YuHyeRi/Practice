

public class Array1_max1min {
	// 배열 내 최대값, 최소값 찾기
	public static void main(String[] args) {

		int arr[] = new int[] {4,56,101,23,45,45};	// 배열 선언
		int max, min;	// 최대값, 최소값 변수 선언
		int maxpos, minpos;	// 몇번째 배열(방)에 있는지 보기 위한 변수 선언
		
		// 1. 최대값 찾기
		max = arr[0];	// 최대값 변수에 0번째 인덱스 값 담기
		maxpos = 0;
		for(int i=0; i<arr.length; i++) {
			if(max<arr[i]) {		// arr를 한바퀴 돌면서, 현재 0번째 인덱스 값보다 크다면
				max = arr[i];		// max에 인덱스 중 가장 큰 값을 담고
				maxpos = i;			// 몇번째 인덱스인지 maxpos에 담는다
			}
		} System.out.printf("최대값 : %d\n", max);
		System.out.printf(" ==> 인덱스 : %d\n", maxpos);
		
		
		// 2. 최소값 찾기
		min = arr[0];
		minpos = 0;
		for(int i=0; i<arr.length; i++) {
			if(min>arr[i]) {
				min = arr[i];
				minpos = i;
			}
		} System.out.printf("최소값 : %d\n", min);
		System.out.printf(" ==> 인덱스 : %d\n", minpos);
		
		
	}
}
