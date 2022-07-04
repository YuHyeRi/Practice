

public class Func4_gogodan {
	// 1. 라인그리기 함수
	public static void displayLine(char mark, int cnt, int cnt2) {
		for(int i=1; i<=cnt; i++) {				// 행(몇줄)
			for(int j=1; j<=cnt2; j++) {		// 열(몇칸)
				System.out.print(mark);
			} System.out.println();}
	}
	
	// 2. 구구단 함수 1
	public static void gugudan(int num) {
		for(int i=1; i<10; i++) {
			System.out.printf("%d x %d = %d\n", num, i, (num*i));}
		System.out.println();
	} 
	
	// 3. 구구단 함수 2
	public static void gugudan(int start, int end) {
		if(start > end) {	// tip! 함수 시작부분에 에러처리 코드를 둔다
			System.out.println("Error!\n시작값이 종료값 보다 큽니다.");
			return;		// 함수를 중간에 언제든지 종료시킬 수 있음
		}
		// 원래코드는 뒤에 쓰기(else를 쓰면 나중에 복잡해지니 되도록 쓰지말자)
		for(int i=start; i<=end; i++) {
			for(int j=1; j<10; j++) {
				System.out.printf("%d x %d = %d\n", i, j, (i*j));
			} System.out.println();} 
	}
	
	public static void main(String[] args) {
		// 1. 라인그리기 함수 실행
		displayLine('*',1,10);
		
		// 2. 구구단함수1 실행
		gugudan(3);
		
		// 3. 구구단함수2 실행
		gugudan(2,4);
		
		// *참고!* Java에서는 동일한 이름의 함수를 여러개 만들 수 있다 ==> "Overloading"
		// 단, 매개변수의 타입 및 갯수 등을 통해 그 함수들의 구분이 가능할 경우 가능하다(다형성)
		
		// *참고!*
		// int ...a ==> 가변배열 : 크기가 바뀌어서, 매개변수 갯수가 지정되어 있지 않은걸 만들 때 사용
		
	}
}
