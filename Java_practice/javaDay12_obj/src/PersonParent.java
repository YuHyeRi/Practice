

// 추상클래스
public abstract class PersonParent {
		String name = "";
		int age = 0;
		
		// 추상메서드 ==> 상속받는 쪽에서 추상메서드를 재정의 해준다 ({}몸통을 써줌)
		abstract void display();

		// getter, setter
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}
}
