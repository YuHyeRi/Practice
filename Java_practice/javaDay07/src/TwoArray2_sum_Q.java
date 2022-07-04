

public class TwoArray2_sum_Q {
	// 행과 열의 합 구하는 프로그램 만들기
	// 한번에 하려하지말고, 행은 행대로 열은 열대로 하나씩
	public static void main(String[] args) {

		int[][]arr = new int[][] {
				{1,2,3,4,0},
				{5,6,7,8,0},
				{10,11,12,13,0},
				{14,15,16,17,0},
				{0,0,0,0,0}};
				
		// 1. 위 배열 그대로 출력하기
		int i,j;
		for(i=0; i<arr.length; i++) {
			for(j=0; j<arr[i].length; j++) {
				System.out.printf("%4d", arr[i][j]);
			} System.out.println();
		}
		
		System.out.println("=======================");
		
		
		// 2. 행 합계 구하기(가로줄)
		for(i=0; i<arr.length-1 ; i++) {
	         arr[i][arr[i].length-1]=0;
	         for(j=0; j<arr[i].length-1; j++)
	            arr[i][arr[i].length-1] += arr[i][j];
	      }
	      
	      for(i=0; i<arr.length; i++) {
	         for(j=0; j<arr[i].length; j++)
	            System.out.printf("%4d", arr[i][j]);
	         System.out.println();
	      }
		
		System.out.println("=======================");
		
		
		// 3. 열 합계 구하기(세로줄)
		 for(i=0; i<arr.length; i++) {
	         arr[arr.length-1][i]=0;
	         for(j=0; j<arr.length-1; j++) 
	            arr[arr.length-1][i]+= arr[j][i];
	      }
	      
	      for(i=0; i<arr.length; i++) {
	         for(j=0; j<arr[i].length; j++)
	            System.out.printf("%4d", arr[i][j]);
	         System.out.println();
	      }
		
		
	}//main
}//class
