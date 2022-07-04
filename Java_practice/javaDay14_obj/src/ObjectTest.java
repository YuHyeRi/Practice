
public class ObjectTest {

	public static void main(String[] args) {
		
		int i = 10;	// 값타입
		
		Object ob = i;	// 객체, 값타입을 참조타입으로 전환가능(필요해서 Integer 클래스 만들어놈)
		// i = ob;	// 참조가 바로 값 타입으로는 못들어감
		// 강제형변환 : Object -> Interger -> int
		
		System.out.println(i);
		
	}
}
