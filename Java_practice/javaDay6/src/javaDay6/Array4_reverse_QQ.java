package javaDay6;

public class Array4_reverse_QQ {
	// 배열의 데이터 순서 반대로 바꾸기
	private static void writeArray(int a[]) {
		for(int i=0; i<a.length; i++)
			System.out.printf("%3d", a[i]);
			System.out.println();
		}
	
	public static void main(String[] args) {
		int[] a = new int[] {1,2,3,4,5,6,7,8,9,10};
		
		// 첫번째 방법
		int[] b = new int[a.length];
		for(int i=0; i<a.length; i++) {
			b[i] = a[(a.length-1) - i];		// a.length-1 : 마지막 방(번호)
		} writeArray(b);
		
		// 두번째 방법
		for(int i=0; i<a.length/2; i++) {
			int temp = a[i];
			a[i] = a[(a.length-1) - i];		// a.length-1 : 마지막 방(번호)
			a[(a.length-1) - i] = temp;
		}
		writeArray(a);
	}
	}