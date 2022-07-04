

public class SchoolParent implements Comparable {
	
	// 변수
	private String name = "";	// private : 지금 클래스에서만 사용가능
	protected int age = 0;		// 부모자식간에는 public, 외부에서는 private
	public String phone = "";
	
	// Getter, Setter
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	// super
	public SchoolParent() {
		super();
	}
	
	// 생성자
	public SchoolParent(String name, int age, String phone) {
		super();
		this.name = name;
		this.age = age;
		this.phone = phone;
	}
	
	@Override			
	public String toString() {
	// System.out.println("오버라이딩 중!");	// 오버라이드(추가)한 내용
	// return super.toString();				// 기존 부모 클래스에 있는 함수를 호출하겠다
	   return name + " " + age + " " + phone + " ";	// 이렇게 부모껄 지우고 오버라이딩도 가능
	}
	
	// 홍길동	-> 사람으로 변경된 것	(자식타입 -> 부모타입 (=> 업캐스팅, 올라가는 형전환, always 허용))
	// 사람	-> 홍길동으로 변경		(부모타입 -> 자식타입 (=> 다운캐스팅, 내려가는 형전환, 원칙적으로 허용X))
	// 예외적으로 자식타입 -> 부모타입 -> 자식타입(원상복구) => 허용
	
	@Override
	// Person -> Object -> Person
	public boolean equals(Object obj) {	// object는 p2
		SchoolParent temp = (SchoolParent)obj;	// 강제 다운캐스팅
		// return super.equals(obj);
		return name.equals(temp.name);
		// 앞name : 홍길동~허길동돌아가면서 들어감, 뒤temp.name : 찾으려는 '박길동' 
	}
	
	@Override
	// 이름만 비교해서 정렬하기
	public int compareTo(Object obj) {
		SchoolParent temp = (SchoolParent) obj;
		return name.compareTo(temp.name);
	}
}

