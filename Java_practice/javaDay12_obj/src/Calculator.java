

// 인터페이스 : 상수, 추상메서드만 OK (*변수 절대 X)
public interface Calculator {

	// abstract 가 앞에 다 생략되어있다고 생각하자!
	// 추상메서드니까 구현은 하면 X
	int add(int x, int y);
	int sub(int x, int y);
	int mul(int x, int y);
	int div(int x, int y);
	
}
