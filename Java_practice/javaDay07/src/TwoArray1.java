

public class TwoArray1 {
	// ������ �迭 ==> ������ ����
	public static void main(String[] args) {
		
		// ������ �迭�� �⺻ ���� ==> ���� i,j
		int[][] a = new int[2][3];	// ��(���η� ����), ��(���ηΰ�)
		
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
		
		// �����迭 ==> ���� i,j,k
		a[0] = new int[2];	// 0��° �࿡ 2ĭ�� ����
		a[1] = new int[4];	// 1��° �࿡ 4ĭ�� ����
		// �� �渶�� ������ �迭�� ��´�
		
		int k = 1;
		for(i=0; i<a.length; i++) {
			for(j=0; j<a[i].length; j++) {
				a[i][j] = k++;		// k�� 1���� �����ؼ� �迭 �ȿ� +1 �� ä������
			}
		}
		
		for(i=0; i<a.length; i++) {
			for(j=0; j<a[i].length; j++) {
				System.out.printf("%3d", a[i][j]);
			} System.out.println();
		}
		
		
	}	//main
}	// class