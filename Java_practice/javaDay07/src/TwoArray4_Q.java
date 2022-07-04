

public class TwoArray4_Q {
	// ¹®Á¦ 10
	public static void main(String[] args) {
		
		int arr[][] = new int[10][10];
		int i, j;
		int k = 1;
		
		// i=0 j=0 00
		// i=1 j=  01 10
		// i=2 j=  02 12 22
		// i=3 j=  03 13 23 43, ...
		for(i=0; i<10; i++) {
			for(j=0; j<=i; j++) {
				arr[j][i] = k;
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
