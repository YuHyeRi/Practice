

public class TwoArray3_Q {
	// ¹®Á¦ 9
	public static void main(String[] args) {
		
		int arr[][] = new int[10][10];
		int i, j;
		int k = 1;
		
		// i=0 j=9
		// i=1 j=8,9
		// i=2 j=7,8,9 ,...
		
		for(i=0; i<10; i++) {
			for(j=9-i; j<10; j++) {
				arr[i][j] = k;
				k++;
			}
		}
		
		for(i=0; i<arr.length; i++) {
			for(j=0; j<arr[i].length; j++) {
				System.out.printf("%4d", arr[i][j]);
			} System.out.println();
		}
		
	}
}
