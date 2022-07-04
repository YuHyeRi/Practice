

import java.util.Scanner;
	// 함수에 배열 전달시, 배열의 크기는 안써도 된다 ==> 타입[] 변수명
public class Func5_array {
	
	// 1. 배열 입력 함수 선언
	public static void readArray(int[]arr) {
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<arr.length; i++) {
			System.out.printf("%d번째 : ", (i+1));
			arr[i] = sc.nextInt();}		// 입력받은 값을 arr 배열에 차곡차곡 저장함
	}
	
	// 2. 배열 출력 함수 선언
	public static void writeArray(int[]arr) {	// arr는 매개변수로서, 함수호출시 전달되는 값을 받아옴
		for(int i=0; i<arr.length; i++) {
			System.out.printf("%3d", arr[i]);
		} System.out.println();
	}
	
	public static void main(String[] args) {
		int[] i = new int[3];	// 아직은 안에 뭐가 있는지 모름
		int[] j = new int[2];	// 아직은 안에 뭐가 있는지 모름
		
		// 1. 배열 입력 함수 호출
		readArray(i);
		readArray(j);
		
		// 2. 배열 출력 함수 호출
		writeArray(i);	// 입력함수를 안쓰면 입력된 값이 없기 때문에 0 0 0 로 출력
		writeArray(j);	// 입력함수를 안쓰면 입력된 값이 없기 때문에 0 0   로 출력
	
	}
}
