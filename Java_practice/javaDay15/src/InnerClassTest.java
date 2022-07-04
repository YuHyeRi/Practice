// 내부클래스 : 클래스 내부에 클래스를 생성 (웹개발보다는 안드로이드개발시 주로 씀)
class Outer {
	int x, y;
	Inner inner = new Inner();
	
	public void calculate() {
		this.x = 10;
		this.y = 20;
		System.out.println(inner.add());
		inner.add();
	}
	
	class Inner {				  // 내부클래스 : Iterator 구축시, 이벤트 프로그래밍시
		int add() { return x+y; } // 내부클래스에서 외부클래스 변수에 자유롭게 접근 가능!
		int sub() { return x-y; }
		int mul() { return x*y; }
		int div() { return x/y; }
	}
}

public class InnerClassTest {
	public static void main(String[] args) {
		Outer o1 = new Outer();
		o1.calculate();
	}
}
