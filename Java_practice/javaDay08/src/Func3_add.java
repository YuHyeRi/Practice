

public class Func3_add {
	// 1. add1 함수 선언 ==> 리턴값 int
	public static int add1(int x, int y) {
		return x + y; }

	// 2. add2 함수 선언 ==> void
	public static void add2(int x, int y) {
		System.out.println(x + y); }
	
	// 3. sigma 함수 선언
	public static int sigma(int limit) {
		int i, sum = 0;
		for(i=1; i<=limit; i++) 
			sum+=i;
			return sum; }
	
	public static void main(String[] args) {
		
		// 출력방법 : 리턴값이 있는 경우
		int result = add1(3,5);
		System.out.println("add1의 결과 : " + result);	// 출력방법 1
		System.out.println("add1의 결과 : " + add1(3,4));	// 출력방법 2
		
		// 출력방법 : 리턴값이 없는 경우 ==> void
		System.out.printf("add2의 결과 : ");
		add2(2,3);	// 함수 단독으로 씀 (변수에 담거나, sysout으로 쓸 수 없음)
		
		// 출력방법 : 리턴값이 있는 경우
		int result3 = sigma(100);
		System.out.println("sigma의 결과 : " + result3);		// 출력방법1
		System.out.println("sigma의 결과 : " + sigma(100));	// 출력방법2
		
		/*
		  -- 객체 생성하여 함수 호출하는 법
		  -- 객체를 통해 호출하게 되면 'static'이란 키워드 없어도 됨
		  Func4 abc = new Func4();		--> 클래스 객체 생성
		  abc.add2(3, 5);	--> void인 경우
		  System.out.println(abc.sigma(100));	--> 리턴값이 있는 경우
		 */
	}
}
