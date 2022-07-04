package javaDay6;

public class Array2_copy {
	// 배열 복사하기 (soft copy, hard copy)
	// java는 배열변수 선언만으로는 메모리가 無
	// 배열변수는 참조변수라서 데이터가 있는 곳의 주소를 저장하기 위한 변수
	// new int[1]; 이때 heap이라는 공간에 정수가 들어갈 메모리 1개를 확보하고, 첫번째 방의 주소를 전달
	// 메모리를 못 줄때는 null 값을 전달
	public static void main(String[] args) {
		
		int[] a = new int[] {1,2,3,4};
		int[] b;
			
		// 1. 얕은복사, soft copy 
		// a가 가르키는 데이터 공간 주소만 복사(참조복사) ==> 따라서, a와 b는 같은 기억공간을 가르킴
		b = a;
		a[0] = 100;		// ==> a와 b는 동일한 데이터공간을 사용하기 때문에 a,b 모두 바뀜	
			
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");	// " " : 공백출력 ==> 100 2 3 4
		} System.out.println();		
		for(int i=0; i<b.length; i++) {
			System.out.print(b[i] + " ");	// " " : 공백출력 ==> 100 2 3 4
		} System.out.println();
			
		// 2. 깊은복사, hard copy
		b = new int[a.length];		// a가 가지고 있는 데이터갯수 만큼 새로운 메모리를 생성
		for(int i=0; i<a.length; i++) {
			b[i] = a[i];}		// a의 값들을 b로 복사 ==> ★for문을 써서 한개씩 옮김★

		a[0] = 50;		// ==> a의 값만 변경, b는 변경되지 않음(영향X)
			
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");	// 50 2 3 4
		}System.out.println();
		for(int i=0; i<b.length; i++) {
			System.out.print(b[i] + " ");	// 100 2 3 4
		}
			
		}
	}