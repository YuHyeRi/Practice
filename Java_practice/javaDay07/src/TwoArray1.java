

public class TwoArray1 {
	// 이차원 배열 ==> 참조의 참조
	public static void main(String[] args) {
		
		// 이차원 배열의 기본 형태 ==> 변수 i,j
		int[][] a = new int[2][3];	// 행(세로로 쌓임), 열(가로로감)
		
		a[0][0]=1;
		a[0][1]=2;
		a[0][2]=3;
		
		a[1][0]=4;
		a[1][1]=5;
		a[1][2]=6;
		
		int i, j;
		for(i=0; i<a.length; i++) {
			for(j=0; j<a[i].length; j++) {
				System.out.printf("%3d", a[i][j]);
			} System.out.println();
		}
		
		System.out.println("============");
		
		// 가변배열 ==> 변수 i,j,k
		a[0] = new int[2];	// 0번째 행에 2칸을 만듦
		a[1] = new int[4];	// 1번째 행에 4칸을 만듦
		// 각 방마다 별도의 배열을 담는다
		
		int k = 1;
		for(i=0; i<a.length; i++) {
			for(j=0; j<a[i].length; j++) {
				a[i][j] = k++;		// k는 1부터 시작해서 배열 안에 +1 씩 채워넣음
			}
		}
		
		for(i=0; i<a.length; i++) {
			for(j=0; j<a[i].length; j++) {
				System.out.printf("%3d", a[i][j]);
			} System.out.println();
		}
		
		
	}	//main
}	// class