

public class Func9_diamond {
	// 다이아몬드 만들기
	public static void diamond(int line) {
		if(line%2 == 0)			// 짝수일때
			line = line + 1;	// 홀수로 만들기
		
		/* 1. 다이아몬드 상단
		 *
		 * 	  *		공백   3 2 1 0
		 * 	 ***	행(i)  1 2 3 4
		 *  *****
		 * *******
		 */
		
		int i, j;
		int line2 = line/2;
		
		for(i=1; i<=line2; i++) {
			for(j=1; j<=(line2-i); j++)
				System.out.print(" ");
			for(j=1; j<=2*i-1; j++)
				System.out.print("*");
			System.out.println();
		}
		
		/*  2. 다이아몬드 하단
		 *
		 * *******
		 * 	*****
		 *   ***
		 *    *
		 */
		for(i=1; i<=line2-1; i++) {
			for(j=1; j<=i; j++)
				System.out.print(" ");
			for(j=1; j<=2*(line2-i)-1; j++)
				System.out.print("*");
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		diamond(8);
		
	}
}
