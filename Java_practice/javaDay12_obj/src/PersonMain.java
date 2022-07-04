

public class PersonMain {
	public static void main(String[] args) {
		
		// PersonParent P1 = new PersonChild();
		// PersonParent클래스는 추상클래스라 객체생성불가
		// 추상클래스는 객체상속을 목적으로 만든 클래스
		// 설계단계에서 작성하는 클래스, 추상메서드를 상속받는 쪽에서 반드시 오버라이딩(메서드완성)해서 써라!
		
		PersonParent p1 = new PersonChild("유헤리", 31, "010-1234-5678");
		p1.display();
	}
}
