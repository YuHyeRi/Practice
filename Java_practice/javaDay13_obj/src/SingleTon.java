
public class SingleTon {
	// 1. static 변수로 singleton 객체 저장변수
	static SingleTon inst = null;	// SingleTon 타입의 inst 변수 생성
	
	// 2. 생성자를 private
	private SingleTon() {}
	
	// 3. 객체를 생성해서 반환하는 내부함수생성
	public static SingleTon getInstance() {
		if(inst == null) {
			inst = new SingleTon();		// 내안에서 나를 생성할 수 있음
		} return inst;
	}
	
	// 공유자원 : 다른곳에서도 같이 사용 가능한 변수들
	public int x;
	public int[] arr = new int[10];
	
}
