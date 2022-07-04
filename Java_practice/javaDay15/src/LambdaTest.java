// 람다식 : 클래스를 생성하지 않고 함수의 호출만으로 기능을 수행

// 1. 함수형 인터페이스를 선언(함수 하나만 가질수 있는 인터페이스)
@ FunctionalInterface
interface MyNumber {
	int getMax(int num1, int num2);	// 인터페이스이기때문에 구현부는 없음
	// getMax함수에 "(x,y) -> (x>=y)? x:y;" 내용이 전달 됨
}

public class LambdaTest {
	public static void main(String[] args) {
		MyNumber max = (x,y) -> (x>=y)? x:y;	// 즉시 객체가 생성됨
		System.out.println(max.getMax(10,20));	// 20 출력
		
		max = (x,y) -> x+y;	// 중간에 함수내용 변경 가능!
		System.out.println(max.getMax(10,20));	// 30 출력
		
		// 익명의 클래스 : 클래스를 상속받아 따로 선언해야 하는데, 이렇게 안하고 간단하게 쓰고 버리는 클래스
		// 부모클래스 객체르르 생성하면서 {}를 붙여주면 새로운 객체가 만들어짐
		// 클래스를 별도로 정의하지 않았기 때문에 이름이 없다 ==> 익명의 클래스
		Object obj = new Object() {		// 부모클래스 객체를 만듦
			@Override
			public String toString() {
				return "**"+super.toString()+"**";
			}
		};
		System.out.println(obj.toString());		// **LambdaTest$1@3c679bde**
	}
}
